import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j < m + 1; j++)
                dp[i][j] = line[j - 1] - '0'; // DP 초기화
        }
        int maxLen = 0;
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++)
                // 선분이 이어질 수 있을 때,
                if (dp[i][j] != 0) {
                    // 해당 선분을 결정하는 세가지 요소들의 최솟값 + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]); // 최대 길이 갱신
                }
        System.out.println(maxLen * maxLen);
    }
}
