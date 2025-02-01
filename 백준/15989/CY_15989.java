import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 더하기_123 {
    static int N, T = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1];
            dp[0] = 1;
            for (int j = 1; j <= 3; j++) {
                for (int i = j; i <= N; i++) {
                    dp[i] += dp[i - j];
                }
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
