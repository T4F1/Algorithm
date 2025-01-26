import java.io.*;

public class ES_2485 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        int[] interval = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(in.readLine());
        }
        for(int i=1; i<n; i++){
            interval[i] = arr[i]-arr[i-1];
        }

        int gcd = interval[1];
        for(int i=1; i<n; i++){
            gcd = gcd(gcd, interval[i]);
        }

        int result = 0;
        for(int i=1; i<n; i++){
            result += (interval[i]-gcd)/gcd;
        }

        System.out.println(result);
    }

    private static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}
