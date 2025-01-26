import java.util.*;
import java.io.*;

public class ES_11051 {
    static int mod = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod;
            }
        }

        System.out.println(dp[n][k]);
    }

}