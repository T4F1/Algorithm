import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) cnt++;
		}
		
		if (cnt % 2 == 0) cnt /= 2;
		else cnt = cnt / 2 + 1;
		System.out.println(cnt);
	}
}
