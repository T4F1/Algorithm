import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static List<String> shortcut = new ArrayList<>();
	
	public static void print(String str, int idx) {
		for (int i = 0; i < str.length(); i++) {
			if (i == idx) {
				sb.append("[" + str.charAt(i) + "]");
			} else {
				sb.append(str.charAt(i));
			}
		}
		sb.append("\n");
	}
	
	public static boolean isShortcut(char c) {
		return !shortcut.contains(Character.toString(Character.toUpperCase(c))) 
				&& !shortcut.contains(Character.toString(Character.toLowerCase(c)));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean flag;
		while (n-- > 0) {
			String str = br.readLine();
			String[] array = str.split(" ");
			int idx = 0;
			flag = false;
			for (int i = 0; i < array.length; i++) {
				if (isShortcut(array[i].charAt(0))) {
					shortcut.add(Character.toString(array[i].charAt(0)));
					flag = true;
					break;
				}
				idx += array[i].length() + 1;
			}
			for (int i = 0; i < str.length(); i++) {
				if (flag) break;
				Character c = str.charAt(i);
				if (c != ' ' && isShortcut(c)) {
					shortcut.add(Character.toString(str.charAt(i)));
					idx = i;
					break;
				}
				
			}
			print(str, idx);
		}
		System.out.println(sb);
	}
}
