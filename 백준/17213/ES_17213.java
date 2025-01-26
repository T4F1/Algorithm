import java.io.*;

public class ES_17213 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        int[][] dp = new int[m+n][m+n];
        for(int i=1; i<m+n; i++){
            dp[i][i] = 1;
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i=2; i<m+n; i++){
            for(int j=2; j<m+n; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[m-1][m-n]);
    }
}