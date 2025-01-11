import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] p = new int[N];
        int[] x = new int[N];
        st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		p[i] = Integer.parseInt(st.nextToken());
    	}
    		
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		x[i] = Integer.parseInt(st.nextToken());
    	
    	
    	int start = p[0] + x[0];
    	int idx = 0, rst = 0;
    	while(start < M) {
    		int next = start;
    		for(int i = idx + 1; i < N; i++) {
    			if(p[i] > start) break;
    			next = Math.max(next, p[i] + x[i]);
				idx = i;
    		}
    		
    		if(next == start) {
    			rst = -1;
    			break;
    		}
    		
    		start = next;
    		rst++;
    	}
    	
    	System.out.println(rst);
    }
    
}
