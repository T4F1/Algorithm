import java.io.*;
import java.util.*;

public class ES_2616 {
    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] sum = new int[n+1];
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        m = Integer.parseInt(in.readLine());

        int[][] dp = new int[4][n+1];
        for(int i=1; i<4; i++){
            for(int j=i*m; j<=n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-m] + sum[j] - sum[j-m]);
            }
        }

        System.out.println(dp[3][n]);
    }
}
