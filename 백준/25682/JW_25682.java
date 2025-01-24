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
        int[][][] dp = new int[n + 1][m + 1][2];
        // 잘못된 타일 계산
        for (int i = 1; i < n + 1; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j < m + 1; j++) {
                if (i % 2 != j % 2) {
                    if (line[j - 1] == 'B')
                        dp[i][j][0] = 1;
                    else
                        dp[i][j][1] = 1;
                } else {
                    if (line[j - 1] == 'W')
                        dp[i][j][0] = 1;
                    else
                        dp[i][j][1] = 1;
                }
            }
        }
        //  누적합 계산
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                dp[i][j][0] += (dp[i - 1][j][0]);
                dp[i][j][1] += (dp[i - 1][j][1]);
            }
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                dp[i][j][0] += (dp[i][j - 1][0]);
                dp[i][j][1] += (dp[i][j - 1][1]);
            }
        
        int minCnt = k * k; // 초기 최댓값
        for (int i = k; i < n + 1; i++)
            for (int j = k; j < m + 1; j++) {
                // 누적합을 이용해서 k 범위 내에 고쳐야하는 타일 수 계산, 최솟값 갱신
                minCnt = Math.min(minCnt, dp[i][j][0] - dp[i - k][j][0] - dp[i][j - k][0] + dp[i - k][j - k][0]);
                minCnt = Math.min(minCnt, dp[i][j][1] - dp[i - k][j][1] - dp[i][j - k][1] + dp[i - k][j - k][1]);
            }
        System.out.println(minCnt);
    }
}
