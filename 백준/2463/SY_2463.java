import java.util.*;
import java.io.*;

public class Main {
	static int MOD = 1_000_000_000;
	static int[] parent, child;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] edgeList = new int[E][3];
		long sum = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edgeList[i][0] = Math.min(a, b);
			edgeList[i][1] = Math.max(a, b);
			edgeList[i][2] = Integer.parseInt(st.nextToken());
			sum += edgeList[i][2];
		}

		parent = new int[N + 1];
		child = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			child[i] = 1;
		}

		long ans = 0;
		Arrays.sort(edgeList, (o1, o2) -> o2[2] - o1[2]);
		for (int[] edge : edgeList) {
			ans += sum * union(edge[0], edge[1]);
			ans %= MOD;
			sum -= edge[2];
		}

		System.out.println(ans);
	}

	public static int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}

	public static long union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY)
			return 0;

		parent[rootY] = rootX;
		long cnt = (long) child[rootX] * child[rootY];
		child[rootX] += child[rootY];
		child[rootY] = 0;

		return cnt;
	}

}
