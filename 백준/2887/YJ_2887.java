import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}

	static int n, result;
	static int[][] planet;
	static int[] parent;
	static PriorityQueue<int[]> pq;
	
	static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		parent[a] = b;
	}
	
	static void kruskal() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		while (!pq.isEmpty()) {
			int now[] = pq.poll();
			int p1 = find(now[0]);
			int p2 = find(now[1]);
			int w = now[2];
			if (p1 != p2) {
				union(p1, p2);
				result += w;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		n = read();
		planet = new int[n][3];
		for (int i = 0; i < n; i++) {
			planet[i][0] = read(); // x좌표
			planet[i][1] = read(); // y좌표
			planet[i][2] = read(); // z좌표
		}
		List<int[]> x = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			x.add(new int[] { i, planet[i][0] });
		}
		Collections.sort(x, (o1, o2) -> o1[1] - o2[1]);

		List<int[]> y = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			y.add(new int[] { i, planet[i][1] });
		}
		Collections.sort(y, (o1, o2) -> o1[1] - o2[1]);

		List<int[]> z = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			z.add(new int[] { i, planet[i][2] });
		}
		Collections.sort(z, (o1, o2) -> o1[1] - o2[1]);

		pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		for (int i = 0; i < n - 1; i++) {
			pq.offer(new int[] { x.get(i)[0], x.get(i + 1)[0], Math.abs(x.get(i)[1] - x.get(i + 1)[1]) });
			pq.offer(new int[] { y.get(i)[0], y.get(i + 1)[0], Math.abs(y.get(i)[1] - y.get(i + 1)[1]) });
			pq.offer(new int[] { z.get(i)[0], z.get(i + 1)[0], Math.abs(z.get(i)[1] - z.get(i + 1)[1]) });
		}
		
		parent = new int[n];
		result = 0;
		kruskal();
		System.out.println(result);
	}
}
