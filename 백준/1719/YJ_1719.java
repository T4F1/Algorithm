import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		int m = read();
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int a = read();
			int b = read();
			int c = read();
			graph.get(a).add(new int[] { b, c });
			graph.get(b).add(new int[] { a, c });
		}
		int[][] answer = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			long[] distance = new long[n + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[i] = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			pq.offer(new int[] { i, 0 });
			
			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				
				for (int[] next : graph.get(now[0])) {
					if (distance[now[0]] + next[1] < distance[next[0]]) {
						distance[next[0]] = distance[now[0]] + next[1];
						pq.offer(new int[] { next[0], (int) distance[next[0]] });
						if (now[0] == i) answer[i][next[0]] = next[0];
						else answer[i][next[0]] = answer[i][now[0]];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) sb.append("-").append(" ");
				else sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
