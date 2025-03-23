import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, m;
	static int[][] board;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

	static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.offer(new int[] { 0, 0, 0 });
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] == n - 1 && now[1] == m - 1)
				return now[2];
			
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if (!isValid(ny, nx)) continue;
				if (!visited[ny][nx] && board[ny][nx] == 0) {
					visited[ny][nx] = true;
					pq.offer(new int[] { ny, nx, now[2] });
				} 
				if (!visited[ny][nx] && board[ny][nx] == 1) {
					visited[ny][nx] = true;
					pq.offer(new int[] { ny, nx, now[2] + 1 });
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		m = read();
		n = read();
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
