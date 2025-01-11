import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] chill = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	chill[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] diff = new int[N-1];
        for(int i = 0; i < N-1; i++) {
        	diff[i] = chill[i + 1] - chill[i];
        }
        
        Arrays.sort(diff);
        
        int rst = 0;
        for(int i = 0; i < N - K; i++) {
        	rst += diff[i];
        }
        
        System.out.println(rst);
    }
    
}
