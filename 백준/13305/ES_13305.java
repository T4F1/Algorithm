import java.io.*;
import java.util.*;

public class ES_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] distances = new int[n-1];
        int[] costs = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0; i<n-1; i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            minCost = Math.min(minCost, costs[i]);
            res += (long) minCost * distances[i];
        }

        System.out.println(res);
    }
}
