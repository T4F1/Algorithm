import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {
    static int N, K = 0;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //가치의 합이 k원이 되게 하고 싶음

        dp = new int[K + 1];
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[K]);
    }
}
