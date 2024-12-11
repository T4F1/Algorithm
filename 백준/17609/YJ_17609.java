import java.util.*;
import java.io.*;

public class Main {
	
	public static int checkPalindrome(String str, int i, int j) {
        boolean skipped = false;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                if (skipped) {
                    return 2; 
                }
                if (isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
            i++;
            j--;
        }
        return 0;
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int answer;
		while (t-- > 0) {
			answer = 0;
			String str = br.readLine();
			int i = 0, j = str.length() - 1;
			answer = checkPalindrome(str, i, j);
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}
