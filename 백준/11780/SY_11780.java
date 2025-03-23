import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] G;
	static Node[][] rst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		G = new int[N + 1][N + 1];
		rst = new Node[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					G[i][j] = 0;
				else
					G[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			G[A][B] = Math.min(G[A][B], W);
		}

		for (int i = 1; i <= N; i++)
			dijkstra(i);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (rst[i][j].dis == Integer.MAX_VALUE)
					sb.append(0).append(" ");
				else
					sb.append(rst[i][j].dis).append(" ");
			}
			sb.append("\n");
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j || rst[i][j].path.size() <= 1)
					sb.append(0).append("\n");
				else {
					sb.append(rst[i][j].path.size()).append(" ");
					for (int node : rst[i][j].path) {
						sb.append(node).append(" ");
					}
					sb.append("\n");
				}
			}
		}

		System.out.println(sb);

	}

	public static void dijkstra(int A) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
		Node[] ans = new Node[N + 1];
		ans[A] = new Node(0, A, null);
		for (int i = 1; i <= N; i++) {
			if (i == A)
				continue;
			ans[i] = new Node(Integer.MAX_VALUE, i, null);
		}
		pq.offer(new Node(0, A, null));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			// 그래프 순회
			for (int i = 1; i <= N; i++) {
				if (G[now.v][i] == Integer.MAX_VALUE)
					continue;
				int totalDis = now.dis + G[now.v][i];
				if (ans[i].dis > totalDis) {
					pq.offer(new Node(totalDis, i, now.path));
					ans[i] = new Node(totalDis, i, now.path);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			rst[A][i] = ans[i];
		}
	}

	public static class Node {
		int dis;
		int v;
		List<Integer> path;

		public Node(int dis, int v, List<Integer> path) {
			this.dis = dis;
			this.v = v;
			this.path = new ArrayList<>();
			if (path != null) {
				for (int vertex : path)
					this.path.add(vertex);
			}
			this.path.add(v);
		}
	}

}
