import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] dp, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][M + 1];
		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(input[j - 1]));
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}

		int maxLen = Math.min(N, M) + 1;
		while (maxLen-- > 0) {
			if (searchSquare(maxLen)) {
				System.out.println(maxLen * maxLen);
				return;
			}
		}

		System.out.println(0);
	}

	public static boolean searchSquare(int len) {
		int area = len * len;

		for (int i = 1; i <= N - len + 1; i++) {
			for (int j = 1; j <= M - len + 1; j++) {
				int[] start = new int[] { i, j };
				int[] end = new int[] { i + len - 1, j + len - 1 };
				int one = dp[start[0] - 1][start[1] - 1];
				int two = dp[start[0] - 1][end[1]];
				int three = dp[end[0]][start[1] - 1];
				if (dp[end[0]][end[1]] - (two + three - one)  == area)
					return true;
			}
		}

		return false;
	}

}
