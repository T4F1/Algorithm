import java.io.*;
public class Main {
	static int[] p, rank;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, i, j, fc;
	public static void main(String[] args) throws Exception {
		N = read(); M = read();
		p = new int[N + 1]; rank = new int[N + 1];
		for (i = 1; i <= N; i++) {
			p[i] = i; rank[i] = 1;
		}
		for (i = 1; i <= N; i++) {
			for (j = 1; j <= N; j++) {
				if (read() == 1) union(i, j);
			}
		}
		fc = find(read());
		for (i = 1; i < M; i++) {
			if (find(read()) != fc) {
				bw.write("NO");bw.flush();bw.close();return;
			}
		}
		bw.write("YES");bw.flush();bw.close();
	}
	public static void union(int x, int y) {
		int X = find(x);int Y = find(y);
		if (X != Y) {
			if (rank[X] > rank[Y]) {p[Y] = X;
			} else if (rank[X] < rank[Y]) {p[X] = Y;
			} else {p[Y] = X;rank[X]++;
			}
		}
	}
	public static int find(int x) {
		if (p[x] != x) p[x] = find(p[x]);
		return p[x];
	}
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
