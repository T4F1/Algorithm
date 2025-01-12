import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Deque<Integer> truck = new ArrayDeque<>();
		Deque<Integer> bridge = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < w; i++) {
			bridge.offer(0);
		}
		
		int time = 0;
		int bridgeW = 0;
		while (!bridge.isEmpty()) {
			time++;
			bridgeW -= bridge.poll();
			if (!truck.isEmpty()) {
				if (bridgeW + truck.peek() <= l) {
					bridgeW += truck.peek();
					bridge.offer(truck.poll());
				} else {
					bridge.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}
