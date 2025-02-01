import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CY_25682 {
    static boolean[][] map;
    static int N, M, K = 0;
    static final char BLACK = 'B';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if (c == 'B') {
                    map[i][j] = true;
                } else if (c == 'W') {
                    map[i][j] = false;
                }
            }
        }
        /*
        black = true
        white = false
         */
        int[][] barr = getSum(true);
        int[][] warr = getSum(false);
        //K개로 쪼갠다.
        System.out.println(Math.min(cutK(barr), cutK(warr)));
    }

    private static int[][] getSum(boolean flag) {
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                boolean cur = map[i - 1][j - 1] == flag;
                int currentValue = 0;
                if ((i + j) % 2 == 0) {
                    currentValue = cur ? 1 : 0;
                } else {
                    currentValue = cur ? 0 : 1;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + currentValue - dp[i - 1][j - 1];
            }
        }
        return dp;
    }

    private static int cutK(int[][] map) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i + K - 1 <= N; i++) {
            for (int j = 1; j + K - 1 <= M; j++) {
                int value =
                        map[i + K - 1][j + K - 1]
                                - map[i + K - 1][j - 1]
                                - map[i - 1][j + K - 1]
                                + map[i - 1][j - 1];
                min = Math.min(value, min);
            }
        }
        return min;
    }
}
