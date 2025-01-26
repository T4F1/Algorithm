import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        	if(o1[0] != o2[0]) return o1[0] - o2[0];
        	return o2[1] - o1[1];
        });
        
        // 3월 1일부터 11월 30일 까지
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] flower = new int[2];
        	int startMonth = Integer.parseInt(st.nextToken());
        	int startDay = Integer.parseInt(st.nextToken());
        	int endMonth = Integer.parseInt(st.nextToken());
        	int endDay = Integer.parseInt(st.nextToken());
        	
        	flower[0] = startMonth*100 + startDay;
        	flower[1] = endMonth*100 + endDay;
        	
        	pq.add(flower);
        }
        
        int startDate = 301;
        int endDate = 1201;
        int max = 0, rst = 0;
        while(startDate < endDate) {
        	boolean isFinded = false;
        	
        	while(true) {
        		if(pq.isEmpty() || pq.peek()[0] > startDate)
        			break;
        		
        		int[] f = pq.poll();
        		
        		if(max < f[1]) {
        			isFinded = true;
        			max = f[1];
        		}
        	}
        	

    		if(isFinded) {
    			startDate = max;
    			rst++;
    		} else break;
        }
        
        if(max < endDate) {
        	System.out.println(0);
        } else {
        	System.out.println(rst);
        }
        
    }
}
