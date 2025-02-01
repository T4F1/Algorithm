import java.io.*;
import java.util.*;

public class ES_4781 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Math.round(Float.parseFloat(st.nextToken()) * 100);
            if (n == 0)
                break;

            int[] dp = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Math.round(Float.parseFloat(st.nextToken()) * 100);

                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j-p] + c);
                }
            }

            System.out.println(dp[m]);
        }
    }
}
