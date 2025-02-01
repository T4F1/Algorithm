import java.io.*;
import java.util.*;

public class ES_1106 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] cities = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(in.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken()); // 비용
            cities[i][1] = Integer.parseInt(st.nextToken()); // 고객 수
        }

        int[] dp = new int[c+101];
        Arrays.fill(dp, 1000 * 100 + 1);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=cities[i][1]; j<c+101; j++){
                dp[j] = Math.min(dp[j], dp[j-cities[i][1]]+cities[i][0]);
            }
        }

        int answer = dp[c];
        for(int i=c; i<c+101; i++){
            answer = Math.min(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
