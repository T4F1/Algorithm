import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, List<Integer>> map = new HashMap<>();
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
				(o1, o2) -> {
					if (o1.get(0) != o2.get(0)) {
						return o1.get(0) - o2.get(0);
					}
					return o1.get(1) - o2.get(1);
				}
			);
		
		for (int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			Integer w = Integer.parseInt(st.nextToken());
			Integer d = Integer.parseInt(st.nextToken());
			Integer p = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>();
			list.add(w);
			list.add(d);
			list.add(p);
			map.put(s, list);				
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int money = Integer.parseInt(st.nextToken());
			List<Integer> list = map.get(s);
			if (list.get(2) <= money) {
				pq.offer(list);
			}
		}
		
		int cnt = 1;
		int max = 1;
		int num = pq.size();
		if (num == 0) {
			max = 0;
		}
		for (int i = 0; i < num - 1; i++) {
			List<Integer> list1 = pq.poll();
			List<Integer> list2 = pq.peek();
			if (list1.get(0) == list2.get(0) && list1.get(1) == list2.get(1)) {
				continue;
			} else if (list1.get(1) < 6) {
				if ((list2.get(0) == list1.get(0)) && (list2.get(1) == list1.get(1) + 1)) {
					cnt++;
				}
				else cnt = 1;
			} else {
				if ((list2.get(0) == list1.get(0) + 1) && (list2.get(1) == list1.get(1) - 6)) {
					cnt++;
				}
				else cnt = 1;
			}
			if (cnt > max) {
				max = cnt;
			}
		}
		System.out.println(max);
		br.close();
	}
}
