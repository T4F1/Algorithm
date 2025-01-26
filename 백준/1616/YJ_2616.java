import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] people = new int[n + 1];
		int[][] dp = new int[4][n + 1];
		int[] sum = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		int t = Integer.parseInt(br.readLine());
		
		// 누적합 구하기
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + people[i];
		}
		
		dp[0][0] = 0;
		for (int i = 1; i < 4; i++) {
			for (int j = t; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - t] + sum[j] - sum[j - t]);
			}
		}
		
		System.out.println(dp[3][n]);
	}
}
