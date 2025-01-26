import java.util.*;
import java.io.*;

public class ES_2960 {
    static int n,k,answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < n + 1; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                if(--k == 0){
                    System.out.println(i);
                    return;
                }
                for (int j = i; i*j<= n; j++) {
                    if(isPrime[i*j]) {
                        isPrime[i * j] = false;
                        if(--k == 0){
                            System.out.println(i*j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
