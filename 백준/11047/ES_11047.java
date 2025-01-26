import java.io.*;
import java.util.*;

public class ES_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n; i++)
            coins[i] = Integer.parseInt(in.readLine());

        int res = 0;
        for(int i=n-1; i>=0; i--) {
            if(coins[i]>k) continue;
            int q = k / coins[i];
            k %= coins[i];
            res += q;
        }
        System.out.println(res);
    }
}
