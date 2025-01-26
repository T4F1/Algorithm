import java.io.*;
import java.util.*;

public class ES_16563 {
    static int n;
    static int MAX = 5_000_000;
    static int[] minPrimes = new int[MAX+1];

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        initMinPrimes();

        for(int value : arr){
            System.out.println(judgePrimes(value));
        }
    }

    private static void initMinPrimes(){
        for(int i=2; i<MAX+1; i++){
            minPrimes[i] = i;
        }
        for(int i=2; i*i<=MAX; i++){
            if(minPrimes[i] == i){
                for(int j=i; j*i<=MAX; j++){
                    if(minPrimes[j*i] == j*i)
                        minPrimes[j*i] = i;
                }
            }
        }
    }

    private static String judgePrimes(int value){
        StringBuilder sb = new StringBuilder();
        while(value != 1){
            sb.append(minPrimes[value]).append(" ");
            value /= minPrimes[value];
        }
        return sb.toString();
    }
}
