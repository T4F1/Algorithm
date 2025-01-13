import java.util.*;
import java.io.*;

public class Main {
	static Deque<Integer> q = new ArrayDeque<>();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        Deque<Integer> trucks = new ArrayDeque<>();
        Deque<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        	trucks.addLast(Integer.parseInt(st.nextToken()));
        for(int i = 0; i < w; i++)
        	bridge.add(0);
        
        int bts = 0;
        int time = 0;
        while(!trucks.isEmpty()) {
        	time++;
        	bts -= bridge.poll();
        	int truck = trucks.poll();
        	if(bts + truck <= L) {
        		bts += truck;
            	bridge.add(truck);
        	} else {
        		bridge.add(0);
        		trucks.addFirst(truck);
        	}
        }
        
        time += bridge.size();
        
        System.out.println(time);
        
    }

}
