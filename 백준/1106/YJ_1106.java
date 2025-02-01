import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 비용
			arr[i][1] = Integer.parseInt(st.nextToken()); // 고객의 수
		}
		int minPrice = Integer.MAX_VALUE;
		int[] dp = new int[100001];
		Arrays.fill(dp, -1);
        dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = arr[i][0]; j <= 100000; j++) {
				if (dp[j - arr[i][0]] != -1) dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
				if (dp[j] >= c) minPrice = Math.min(minPrice, j);
			}
		}
		System.out.println(minPrice);
	}
}
