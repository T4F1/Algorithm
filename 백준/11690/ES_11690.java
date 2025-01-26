import java.io.*;
import java.util.*;

public class ES_11690 {
    static long n;
    static boolean[] isPrime;
    static List<Integer> primes = new ArrayList<>();
    static long mod = (long)Math.pow(2,32);
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        isPrime = new boolean[(int)n+1];
        getPrimes();

        long result = 1;
        for(int prime : primes){
            long pow = prime;
            while(pow * prime <= n){
                pow *= prime;
            }
            result = (result*pow) % mod;
        }
        System.out.println(result);
    }

    private static void getPrimes(){
        for(int i=2; i<=n; i++)
            isPrime[i] = true;

        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i; j*i<=n; j++){
                    isPrime[i*j] = false;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(isPrime[i]) primes.add(i);
        }
    }
}