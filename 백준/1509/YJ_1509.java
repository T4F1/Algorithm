import java.util.*;
import java.io.*;

public class Main {

	public static String str;
	public static int n;
	public static boolean palindrome[][];
	public static int dp[];

	public static boolean isPalindrome(int idx1, int idx2) {
		int l = idx1, r = idx2;
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		n = str.length();
		palindrome = new boolean[n][n];
		dp = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				palindrome[i][j] = isPalindrome(i, j);
			}
		}
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = i - 1; j >= 0; j--) {
				if (palindrome[j][i - 1]) {
					if (dp[i] > dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		System.out.println(dp[n]);
	}
}
