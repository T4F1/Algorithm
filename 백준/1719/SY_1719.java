import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int N, M;
	static List<int[]>[] G;
	static int[][] table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		G = new List[N + 1];
		table = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++)
			G[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			G[A].add(new int[] { B, W });
			G[B].add(new int[] { A, W });
		}

		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					sb.append("- ");
				else {
					sb.append(table[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	// 핵심은 다익스트라의 경로를 어떻게 저장해야하는지? 임
	// 다익스트라의 역추적을 활용하면 됨

	public static void dijkstra(int A) {
		PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
		node[] rst = new node[N + 1];
		for (int i = 1; i <= N; i++)
			rst[i] = new node(Integer.MAX_VALUE, i, null);

		pq.offer(new node(0, A, null));

		while (!pq.isEmpty()) {
			node now = pq.poll();

			for (int[] v : G[now.v]) {
				int totalDis = v[1] + now.dis;
				if (totalDis < rst[v[0]].dis) {
					pq.offer(new node(totalDis, v[0], now.path));
					rst[v[0]] = new node(totalDis, v[0], now.path);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (A == i)
				continue;
			table[A][i] = rst[i].path.get(1);
		}

	}

	public static class node {
		int dis;
		int v;
		List<Integer> path;

		public node(int dis, int v, List<Integer> path) {
			this.dis = dis;
			this.v = v;
			this.path = new ArrayList<>();
			if (path != null)
				for (int n : path)
					this.path.add(n);
			this.path.add(v);
		}
	}

}
