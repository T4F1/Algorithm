import java.util.*;
import java.io.*;

public class Main {
	static Deque<Integer> q = new ArrayDeque<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= N; i++) q.add(i);
        
        int[] nums = new int[M];
      
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
        	nums[i] = Integer.parseInt(st.nextToken());
        
        int rst = 0;
        for(int i = 0; i < M; i++) {
        	int cnt = 0;
        	while(q.peek() != nums[i]) {
        		cnt++;
        		rotateRight();
        	}
        	
        	rst += Math.min(N - cnt, cnt);
        	q.pollFirst();
        	N--;
        }
        
        System.out.println(rst);
    }

    private static void rotateRight() {
    	int num = q.pollFirst();
    	q.add(num);
    }
    
}
