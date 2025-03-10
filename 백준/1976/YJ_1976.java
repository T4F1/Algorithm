import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int[] num;

	public static void union(int a, int b) {
		if (find(a) != find(b)) {
			num[find(a)] = find(b);
		}
	}

	public static int find(int a) {
		if (num[a] == a)
			return a;
		return num[a] = find(num[a]);
	}

	public static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (read() == 1) {
					union(i, j);
				}
			}
		}
		int[] travel = new int[m];
		for (int i = 0; i < m; i++) {
			travel[i] = read() - 1;
		}
		boolean flag = true;
		for (int i = 0; i < m - 1; i++) {
			if (!isSame(travel[i], travel[i + 1])) {
				flag = false;
				break;
			}
		}
		if (flag) System.out.println("YES");
		else System.out.println("NO");
	}
}
