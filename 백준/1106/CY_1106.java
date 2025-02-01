import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔 {
    static int C, N = 0;
    static int answer = Integer.MAX_VALUE;

    static int dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE >> 2);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            String[] value = br.readLine().split(" ");
            int cost = Integer.parseInt(value[0]);
            int people = Integer.parseInt(value[1]);
            for (int j = people; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }
        }
        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}