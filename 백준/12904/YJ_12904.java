import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String s = br.readLine();
		String t = br.readLine();
		sb = new StringBuilder(t);
		
		while (s.length() != sb.length()) {
			int lastIdx = sb.length() - 1;
			if (sb.charAt(lastIdx) == 'A') {
				sb.deleteCharAt(lastIdx);
			} else if (sb.charAt(lastIdx) == 'B') {
				sb.deleteCharAt(lastIdx);
				sb.reverse();
			}
		}
		
		if (s.equals(sb.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
