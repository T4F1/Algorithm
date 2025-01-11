import java.util.*;
import java.io.*;

public class Main {
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		
		int cnt1 = solve('0', '1');
		int cnt2 = solve('1', '0');
		
		System.out.println(Math.min(cnt1, cnt2));
	}
	
	private static int solve(char c1, char c2) {
		int cnt = 0;
		char prevNum = input[0];
		for(int i = 1; i < input.length; i++) {
			if(input[i] == c1) {
				if(prevNum == c2) {
					cnt++;
					prevNum = c1;
				}
			} else {
				prevNum = c2;
			}
		}
		
		if(prevNum == c2) cnt++;
		
		return cnt;
	}
	
}
