import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[][] board = new char[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				board[i][j] = str.charAt(j - 1);
			}
 		}
		int[][][] sum = new int[2][n + 1][m + 1];
		int[][][] dp = new int[2][n + 1][m + 1];

		// B로 시작할 때 바꿔야 하는 정사각형의 개수 누적합
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if ((i + j) % 2 == 0 && board[i][j] != 'B' || (i + j) % 2 != 0 && board[i][j] != 'W') {
					sum[0][i][j] += 1;
				}
				sum[0][i][j] += sum[0][i - 1][j] + sum[0][i][j - 1] - sum[0][i - 1][j - 1];
			}
		}
		
		// k*k 크기 중 누적합의 최소 구하기
		int bMin = Integer.MAX_VALUE;
		for (int i = k; i <= n; i++) {
			for (int j = k; j <= m; j++) {
				bMin = Math.min(bMin, sum[0][i][j] - sum[0][i - k][j] - sum[0][i][j - k] + sum[0][i - k][j - k]);
			}
		}
		
		// W로 시작할 때 바꿔야 하는 정사각형의 개수 누적합
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if ((i + j) % 2 == 0 && board[i][j] != 'W' || (i + j) % 2 != 0 && board[i][j] != 'B') {
					sum[1][i][j] += 1;
				}
				sum[1][i][j] += sum[1][i - 1][j] + sum[1][i][j - 1] - sum[1][i - 1][j - 1];
			}
		}
		
		// k*k 크기 중 누적합의 최소 구하기
		int wMin = Integer.MAX_VALUE;
		for (int i = k; i <= n; i++) {
			for (int j = k; j <= m; j++) {
				wMin = Math.min(wMin, sum[1][i][j] - sum[1][i - k][j] - sum[1][i][j - k] + sum[1][i - k][j - k]);
			}
		}
		
		System.out.println(Math.min(bMin, wMin));
	}
}
