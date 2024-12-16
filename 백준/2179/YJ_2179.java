import java.util.*;
import java.io.*;

public class Main {
	
	public static int countPrefix(String word1, String word2) {
		int cnt = 0;
		
		if (word1.length() < word2.length()) {
			for (int i = 0; i < word1.length(); i++) {
				if (word1.charAt(i) == word2.charAt(i)) cnt++;
				else break;
			}
		} else {
			for (int i = 0; i < word2.length(); i++) {
				if (word1.charAt(i) == word2.charAt(i)) cnt++;
				else break;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		int max = -1;
		String s = "", t = "";
		
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n ; j++) {
				String str1 = list.get(i);
				String str2 = list.get(j);
				int cnt = countPrefix(str1, str2);
				if (cnt > max) {
					max = cnt;
					s = str1;
					t = str2;
				}
			}
		}
		System.out.println(s);
		System.out.println(t);
		br.close();
	}
}
