import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		for (int i = 0; i < routes.length; i++) {
			pq.offer(routes[i]);
		}
		int cnt = 0;
		int prevPoint = -30000;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] > prevPoint) {
				cnt++;
				prevPoint = now[1];
			}
		}
		return cnt;
    }
}
