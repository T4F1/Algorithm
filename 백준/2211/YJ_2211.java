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
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = distance[1] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.offer(new int[] { 0, 1, 0 });
		sb.append(n - 1).append("\n");
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (!visited[now[1]]) {
				visited[now[1]] = true;
				sb.append(now[0]).append(" ").append(now[1]).append("\n");
			}
			for (int[] v : graph.get(now[1])) {
				if (distance[v[0]] > distance[now[1]] + v[1]) {
					distance[v[0]] = distance[now[1]] + v[1];
					pq.offer(new int[] { now[1], v[0], distance[v[0]] });
				}
			}
		}
		System.out.println(sb);
	}
}
