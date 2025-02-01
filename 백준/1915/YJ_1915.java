import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] board;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				board[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		// 누적합 구하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = board[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}
		
		int size = Math.min(n, m) + 1;
		while (size-- > 0) {
			int area = size * size;
			for (int i = n; i >= size; i--) {
				for (int j = m; j >= size; j--) {
					if (dp[i][j] - dp[i - size][j] - dp[i][j - size] + dp[i - size][j - size] == area) {
						System.out.println(area);
						System.exit(0);
					}
				}
			}
		}		
	}
}
