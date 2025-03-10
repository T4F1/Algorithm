import java.util.*;
import java.io.*;

public class Main {
	static Map<String, Integer> friend;
	static int[] fList, parent, rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = read();

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			friend = new HashMap<>();
			int F = read();
			fList = new int[F * 2];
			parent = new int[F * 2];
			rank = new int[F * 2];
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				fList[i] = 1;
				rank[i] = 1;
			}

			int idx = 0;
			while (F-- > 0) {
				
				// StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = readString();
				String name2 = readString();
				if (!friend.keySet().contains(name1)) {
					friend.put(name1, idx);
					idx++;
				}
				if (!friend.keySet().contains(name2)) {
					friend.put(name2, idx);
					idx++;
				}

				int idx1 = friend.get(name1);
				int idx2 = friend.get(name2);

				union(idx1, idx2);
				int p = find(idx1);
				sb.append(fList[p]).append("\n");
			}

		}

		System.out.println(sb);
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (fList[rootX] > fList[rootY]) {
				parent[rootY] = rootX;
				fList[rootX] += fList[rootY];
			} else if (fList[rootX] < fList[rootY]) {
				parent[rootX] = rootY;
				fList[rootY] += fList[rootX];
			} else {
				parent[rootX] = rootY;
				fList[rootY] += fList[rootX];
				rank[rootX] += 1;
			}

		}
	}

	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	private static String readString() throws Exception {
		StringBuilder sb = new StringBuilder();
		int c;
		while ((c = System.in.read()) > 32)
			sb.append((char) c);
		return sb.toString();
	}

}
