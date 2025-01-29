import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n + 1]; // 메모리
		int[] c = new int[n + 1]; // 비용
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int maxCost = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			if (c[i] > maxCost) maxCost = c[i];
		}
		int[][] dp = new int[n + 1][n * maxCost + 1];
		int minCost = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < c[i]; j++) dp[i][j] = dp[i - 1][j];
			for (int j = c[i]; j <= n * maxCost; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + a[i]);
				if (dp[i][j] >= m) {
					minCost = Math.min(minCost, j);
				}
			}
		}
		System.out.println(minCost);
	}
}
