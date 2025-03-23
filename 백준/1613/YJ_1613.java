import java.util.*;
import java.io.*;

public class Main {

//	static int read() throws Exception {
//		int c, n = System.in.read() & 15;
//		boolean m = n == 13;
//		if (m) n = System.in.read() & 15;
//		while ((c = System.in.read()) >= 48)
//			n = (n << 3) + (n << 1) + (c & 15);
//		return m ? ~n + 1 : n;
//	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	 public static void main(String[] args) throws Exception {
		int n = read();
		int k = read();

		boolean[][] arr = new boolean[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			int x = read();
			int y = read();

			arr[x][y] = true;
		}

		// 플로이드 와샬 알고리즘
		for (int p = 1; p <= n; p++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][p] && arr[p][j]) {
						arr[i][j] = true;
					}
				}
			}
		}

		int s = read();
		StringBuilder sb = new StringBuilder();
		while (s-- > 0) {
			int x = read();
			int y = read();

			if (x < 1 || y < 1 || x > n || y > n) { // 주어진 범위에서 벗어날 경우
				sb.append("0\n");
			} else {
				if (arr[x][y]) { // x에서 y로 갈 수 있다는 뜻은 사건이 먼저 일어났다는 뜻
					sb.append("-1\n");
				} else {
					if (arr[y][x]) { // y에서 x로 갈 수 있다는 뜻은 사건이 나중에 일어났다는 뜻
						sb.append("1\n");
					} else { // x에서 y, y에서 x로 모두 갈 수 없으면 상관 없는 사건 관계임
						sb.append("0\n");
					}
				}
			}
		}
		System.out.println(sb);
	}
}
