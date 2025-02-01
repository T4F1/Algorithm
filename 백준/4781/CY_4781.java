import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕가게 {
    static int T, M = 0;
    static int[] dp;
    static int[] money;
    static int[] calories;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            M = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            if (T == 0) {
                break;
            }
            calories = new int[T + 1];
            money = new int[T + 1];
            dp = new int[M + 1]; //가격 i에서 가질 수 있는 최대 칼로리

            for (int test = 1; test <= T; test++) {
                st = new StringTokenizer(br.readLine());
                calories[test] = Integer.parseInt(st.nextToken());
                money[test] = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            }
            for (int i = 1; i <= T; i++) {
                for (int j = money[i]; j <= M; j++) {
                    dp[j] = Math.max(dp[j], dp[j - money[i]] + calories[i]);
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}
