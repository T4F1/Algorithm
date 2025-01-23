import java.io.*;
import java.util.*;

public class ES_1915 {
    static int[][] map;
    static int[][] dp;
    static int n, m, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        calcDp(n, m);

        for (int len = 1; len <= Math.min(n, m); len++) {
            calcArea(len);
        }

        System.out.println(answer);
    }

    private static void calcArea(int len) {
        for (int i = n - 1; i >= len; i--) {
            for (int j = m - 1; j >= len; j--) {
                int area = dp[i][j];
                if (i - len >= 0) {
                    area -= dp[i - len][j];
                }
                if (j - len >= 0) {
                    area -= dp[i][j - len];
                }
                if (i - len >= 0 && j - len >= 0) {
                    area += dp[i - len][j - len];
                }

                if (area == len * len) {
                    answer = Math.max(answer, area);
                }
            }
        }
    }

    private static void calcDp(int n, int m) {
        // 누적합 구하기 로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = map[i][j];
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] -= dp[i - 1][j - 1];
                }
            }
        }
    }
}