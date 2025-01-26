import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] train = new int[N + 1];
		int[] total = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			train[i] = Integer.parseInt(st.nextToken());
			total[i] = total[i - 1] + train[i];
		}

		int[][] dp = new int[4][N + 1];
		int K = Integer.parseInt(br.readLine());

		for (int i = 1; i < 4; i++) {
			for (int j = i * K; j <= N; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + total[j] - total[j - K]);
			}
		}

		System.out.println(dp[3][N]);
	}
}
