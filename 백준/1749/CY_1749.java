import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점수따먹기 {
    static int[][] map;
    static int N, M = 0;
    static int MAX = Integer.MIN_VALUE;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //누적합 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i - 1][j - 1];
            }
        }
        for (int r = 1; r < N; r++) {
            for (int c = 1; c < M; c++) {
                for (int i = 1; i + r - 1 <= N; i++) {
                    for (int j = 1; j + c - 1 <= M; j++) {
                        int value = dp[i + r - 1][j + c - 1] - dp[i + r - 1][j - 1] - dp[i - 1][j + c - 1]
                                + dp[i - 1][j - 1];
                        MAX = Math.max(value, MAX);
                    }
                }
            }
        }
        System.out.println(MAX);
    }
}
