import java.util.*;
import java.io.*;

public class Main {

	private static final int MOD = 900528;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			charMap.put(arr[i], i+1);
		}
    
    char[] pw = br.readLine().toCharArray();
    
		int a = 1;
		int r = arr.length;
		int result = 0;
		for(int i = pw.length - 1; i >= 0; i--) {
			result = (result + (a*charMap.get(pw[i]))%MOD)%MOD;
			a = (a*r)%MOD;
		}
		
		System.out.println(result);
		
		br.close();
	}
}
