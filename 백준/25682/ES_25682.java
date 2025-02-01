import java.io.*;
import java.util.*;

public class ES_25682 {
    static int n, m, k;
    static boolean[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        dp = new int[2][n][m]; // 0: B로 시작, 1: W로 시작

        for (int i = 0; i < n; i++) {
            char[] tmp = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j] == 'W'; // B는 false, W는 true
            }
        }

        dp[0] = calcSum(false); // B로 시작하는 체스판
        dp[1] = calcSum(true);  // W로 시작하는 체스판
        System.out.println(calcAnswer());
    }

    private static int calcAnswer() {
        int answerB = Integer.MAX_VALUE;
        int answerW = Integer.MAX_VALUE;

        for (int i = k - 1; i < n; i++) {
            for (int j = k - 1; j < m; j++) {
                int cntB = dp[0][i][j];
                int cntW = dp[1][i][j];

                if (i - k >= 0) {
                    cntB -= dp[0][i - k][j];
                    cntW -= dp[1][i - k][j];
                }
                if (j - k >= 0) {
                    cntB -= dp[0][i][j - k];
                    cntW -= dp[1][i][j - k];
                }
                if (i - k >= 0 && j - k >= 0) {
                    cntB += dp[0][i - k][j - k];
                    cntW += dp[1][i - k][j - k];
                }

                answerB = Math.min(cntB, answerB);
                answerW = Math.min(cntW, answerW);
            }
        }

        return Math.min(answerB, answerW);
    }

    // 누적합 구하기
    private static int[][] calcSum(boolean color) {
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) arr[i][j] += arr[i - 1][j];
                if (j > 0) arr[i][j] += arr[i][j - 1];
                if (i > 0 && j > 0) arr[i][j] -= arr[i - 1][j - 1];

                // 현재 칸이 color로 되어 있어야 하는지 검사
                boolean expectedColor = (i + j) % 2 == 0 ? color : !color;
                if (board[i][j] != expectedColor) {
                    arr[i][j]++;
                }
            }
        }

        return arr;
    }
}