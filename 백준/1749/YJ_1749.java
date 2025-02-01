import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적합 구하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = board[i][j] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
			}
		}
		
		// 구간합 구하기
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int p = i - 1; p >= 0; p--) {
					for (int q = j - 1; q >= 0; q--) {
						int sum = dp[i][j] - dp[i][q] - dp[p][j] + dp[p][q];
						if (sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
