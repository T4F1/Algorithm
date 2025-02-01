import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {
    static int[][] dp; // dp[i][j] : i번째 앱까지 고려했을 때, j비용으로 얻을 수 있는 최대 메모리
    static int[] memories; // 각 앱이 사용하는 메모리
    static int[] costs; // 각 앱을 비활성화할 때 드는 비용
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 앱의 수
        M = Integer.parseInt(st.nextToken()); // 필요한 메모리

        memories = new int[N];
        costs = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] : j 비용으로 얻을 수 있는 최대 메모리
        dp = new int[N][10001]; // 최대 비용은 100 * 100 = 10000
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int cost = costs[i];
            int memory = memories[i];

            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= cost) {
                        dp[i][j] = memory;
                    }
                } else {
                    if (j >= cost) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }
}