import java.util.*;
import java.io.*;

public class Main {
	static List<int[]>[] Tree;
	static int N, max, maxNode;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		max = Integer.MIN_VALUE;
		maxNode = -1;
		N = Integer.parseInt(br.readLine());
		
		Tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			Tree[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			while (true) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1)
					break;
				int d = Integer.parseInt(st.nextToken());
				Tree[node].add(new int[] { v, d });
			}
		}

		dfs(1, 0);
		visited = new boolean[N + 1];
		dfs(maxNode, 0);

		System.out.println(max);
	}

	public static void dfs(int v, int dis) {
		if (dis > max) {
			max = dis;
			maxNode = v;
		}

		visited[v] = true;

		for (int[] node : Tree[v]) {
			if (!visited[node[0]]) {
				dfs(node[0], node[1] + dis);
			}
		}

	}
}
