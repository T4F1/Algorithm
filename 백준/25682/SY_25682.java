import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[][] convert1, convert2, dp1, dp2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		convert1 = new int[N][M];
		convert2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = input[j];
			}
		}

		// BWBWBW...
		boolean isBlack = true;
		for (int i = 0; i < N; i++) {
			if (i == 0)
				isBlack = true;
			if (i % 2 == 0)
				isBlack = true;
			else if (i % 2 != 0)
				isBlack = false;

			for (int j = 0; j < M; j++) {
				if (isBlack) {
					if (board[i][j] == 'B')
						convert1[i][j] = 0;
					else
						convert1[i][j] = 1;
				} else {
					if (board[i][j] == 'W')
						convert1[i][j] = 0;
					else
						convert1[i][j] = 1;
				}
				isBlack = !isBlack;
			}
		}

		// WBWBWB...
		for (int i = 0; i < N; i++) {
			if (i == 0)
				isBlack = false;
			if (i % 2 == 0)
				isBlack = false;
			else if (i % 2 != 0)
				isBlack = true;

			for (int j = 0; j < M; j++) {
				if (isBlack) {
					if (board[i][j] == 'B')
						convert2[i][j] = 0;
					else
						convert2[i][j] = 1;
				} else {
					if (board[i][j] == 'W')
						convert2[i][j] = 0;
					else
						convert2[i][j] = 1;
				}
				isBlack = !isBlack;
			}
		}

		dp1 = calTotalSum(convert1);
		dp2 = calTotalSum(convert2);

		System.out.println(Math.min(findMinValue(dp1), findMinValue(dp2)));

	}

	public static int[][] calTotalSum(int[][] convert) {
		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + convert[i - 1][j - 1];
			}
		}

		return dp;
	}

	public static int findMinValue(int[][] dp) {
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = 1; j <= M - K + 1; j++) {
				int[] start = new int[] { i, j };
				int[] end = new int[] { i + K - 1, j + K - 1 };

				int sum = dp[end[0]][end[1]] + dp[start[0] - 1][start[1] - 1] - dp[start[0] - 1][end[1]]
						- dp[end[0]][start[1] - 1];
				if (min > sum)
					min = sum;
			}
		}

		return min;
	}

}
