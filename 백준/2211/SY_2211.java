import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int N, M;
	static List<int[]>[] G;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		G = new List[N + 1];
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

		Node[] rst = dijkstra(1);
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			List<Integer> path = rst[i].path;
			int pv = 1;
			for (int v : path) {
				if (find(pv) != find(v)) {
					sb.append(pv + " " + v).append("\n");
					cnt++;
				}

				union(pv, v);
				pv = v;
			}
		}

		System.out.println(cnt);
		System.out.println(sb);
	}

	public static Node[] dijkstra(int A) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
		Node[] rst = new Node[N + 1];
		for (int i = 1; i <= N; i++)
			rst[i] = new Node(Integer.MAX_VALUE, i, null);

		pq.offer(new Node(0, A, null));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (int[] v : G[now.v]) {
				int totalDis = v[1] + now.dis;
				if (totalDis < rst[v[0]].dis) {
					pq.offer(new Node(totalDis, v[0], now.path));
					rst[v[0]] = new Node(totalDis, v[0], now.path);
				}
			}
		}

		return rst;
	}

	public static class Node {
		int dis;
		int v;
		List<Integer> path;

		public Node(int dis, int v, List<Integer> path) {
			this.dis = dis;
			this.v = v;
			this.path = new ArrayList<>();
			if (path != null)
				for (int n : path)
					this.path.add(n);
			this.path.add(v);
		}

	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY)
			parent[y] = rootX;
	}

	public static int find(int x) {
		if (parent[x] != x)
			return parent[x] = find(parent[x]);
		return parent[x];
	}

}
