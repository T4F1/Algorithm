import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		long sum = 0;
		Map<String, PriorityQueue<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			PriorityQueue<Integer> pq;
			if (n == 1) {
				if (!map.containsKey(name)) {
					 pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
				} else {
					pq = map.get(name);
				}
				int k = Integer.parseInt(st.nextToken());
				for (int j = 0; j < k; j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
				map.put(name, pq);
			} else if (n == 2) {
				if (map.containsKey(name)) {
					int b = Integer.parseInt(st.nextToken());
					pq = map.get(name);
					if (b >= pq.size()) {
						while (!pq.isEmpty()) {
							sum += pq.poll();
						}
					} else {
						for (int j = 0; j < b; j++) {
							sum += pq.poll();
						}
					}
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
