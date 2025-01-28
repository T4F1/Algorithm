import java.io.*;
import java.util.*;

public class ES_2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n;i ++){
            coins[i] = Integer.parseInt(in.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){ // 코인을 순회
            int coin = coins[i];
            for(int j=coin; j<=k; j++){ // 금액을 순회
                    dp[j] += dp[j-coin];
            }
        }
        System.out.println(dp[k]);
    }
}