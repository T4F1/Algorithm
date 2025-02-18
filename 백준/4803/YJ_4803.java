import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static List<List<Integer>> edges;
	static boolean[] visited;
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	public static boolean bfs(int start) {
		int edgeCnt = 0;
		int vertexCnt = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(start);
		visited[start] = true;
		while (!dq.isEmpty()) {
			int now = dq.poll();
			vertexCnt++;
			
			for (int u : edges.get(now)) {
				edgeCnt++;
				if (!visited[u]) {
					dq.offer(u);
					visited[u] = true;
				}
			}
		}
		return edgeCnt / 2 == vertexCnt - 1;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int test = 0;
		while (true) {
			n = read();
			int m = read();
			if (n == 0 && m == 0) break;
			edges = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				edges.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				int v = read();
				int u = read();
				edges.get(v).add(u);
				edges.get(u).add(v);
			}
			int treeCnt = 0;
			visited = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					if (bfs(i)) treeCnt++;
				}
			}
			sb.append("Case ").append(test + 1);
			switch(treeCnt) {
				case 0: sb.append(": No trees."); break;
				case 1: sb.append(": There is one tree."); break;
				default: sb.append(": A forest of ").append(treeCnt).append(" trees."); break;
			}
			sb.append("\n");
			test++;
		}
		System.out.println(sb);
	}
}
