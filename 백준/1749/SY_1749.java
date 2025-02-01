import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[N][M];
		int[][] dp = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 누적합 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		// 누적합 최솟값 구하기
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int rst = findMaxValue(i, j, dp);
				if (max < rst)
					max = rst;
			}
		}

		System.out.println(max);

	}

	public static int findMaxValue(int y, int x, int[][] dp) {
		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N - y + 1; i++) {
			for (int j = 1; j <= M - x + 1; j++) {
				int[] start = new int[] { i, j };
				int[] end = new int[] { i + y - 1, j + x - 1 };

				int sum = dp[end[0]][end[1]] - dp[start[0] - 1][end[1]] - dp[end[0]][start[1] - 1]
						+ dp[start[0] - 1][start[1] - 1];
				if (sum > max)
					max = sum;
				
				if(max == 103)
					break;
			}
		}

		return max;

	}

}
