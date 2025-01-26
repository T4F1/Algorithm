import java.io.*;
import java.util.*;

public class ES_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while(t-->0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for(int i=0; i<arr.length-1; i++){
                for(int j=i+1; j<arr.length; j++){
                    sum += gcd(arr[i],arr[j]);
                }
            }
            System.out.println(sum);
        }
    }

    private static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}