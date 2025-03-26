import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, m, k, visitedCnt, totalW;
	static int[] parent;
	static boolean[] visited;
	static List<Integer> electric;
	static PriorityQueue<int[]> pq;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static boolean union(int x, int y) {
	    x = find(x);
	    y = find(y);

	    if (x == y) return false;

	    boolean xIsElectric = electric.contains(x);
	    boolean yIsElectric = electric.contains(y);

	    if (xIsElectric && yIsElectric) return false;
	    if (xIsElectric) parent[y] = x;
	    else if (yIsElectric) parent[x] = y;
	    else parent[y] = x;

	    return true;
	}

	static void mst() {
		while (!pq.isEmpty()) {
	        int[] now = pq.poll();
	        int u = now[0], v = now[1], w = now[2];

	        if (union(u, v)) {
	            totalW += w;
	        }
	    }
	}

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		k = read();
		visited = new boolean[n + 1];
		electric = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int e = read();
			electric.add(e);
			visited[e] = true;
		}
		pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		for (int i = 0; i < m; i++) {
			int u = read();
			int v = read();
			int w = read();
			pq.offer(new int[] { u, v, w });
		}
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		visitedCnt = k;
		totalW = 0;
		mst();
		System.out.println(totalW);
	}
}
