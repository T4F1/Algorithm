import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[2][n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j < m + 1; j++) {
                if (i % 2 != j % 2) {
                    if (line[j - 1] == 'B')
                        dp[0][i][j] = 1;
                    else
                        dp[1][i][j] = 1;
                } else {
                    if (line[j - 1] == 'W')
                        dp[0][i][j] = 1;
                    else
                        dp[1][i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                dp[0][i][j] += (dp[0][i - 1][j]);
                dp[1][i][j] += (dp[1][i - 1][j]);
            }
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                dp[0][i][j] += (dp[0][i][j - 1]);
                dp[1][i][j] += (dp[1][i][j - 1]);
            }
        int minCnt = k * k;
        for (int i = k; i < n + 1; i++)
            for (int j = k; j < m + 1; j++) {
                minCnt = Math.min(minCnt, dp[0][i][j] - dp[0][i - k][j] - dp[0][i][j - k] + dp[0][i - k][j - k]);
                minCnt = Math.min(minCnt, dp[1][i][j] - dp[1][i - k][j] - dp[1][i][j - k] + dp[1][i - k][j - k]);
            }
        System.out.println(minCnt);
    }
}