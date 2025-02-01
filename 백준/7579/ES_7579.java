import java.io.*;
import java.util.*;

public class ES_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(in.readLine());
        StringTokenizer st2 = new StringTokenizer(in.readLine());
        int[] memories = new int[n];
        int[] costs = new int[n];
        int totalCost = 0;

        for(int i=0; i<n; i++){
            memories[i] = Integer.parseInt(st1.nextToken());
            costs[i] = Integer.parseInt(st2.nextToken());
            totalCost += costs[i];
        }

        int[][] dp = new int[n][totalCost+1];
        for(int i=0; i<= totalCost; i++){
            if(i>=costs[0]) dp[0][i] = memories[0];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<totalCost; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= costs[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-costs[i]] + memories[i]);
            }
        }

        for(int i=1; i<totalCost; i++){
            if (dp[n - 1][i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
