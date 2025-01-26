import java.io.*;
import java.util.*;

public class Main2 {
	
	static int n, m;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
	
	static boolean isPossible(int y, int x, boolean[][] visited) {
		return isValid(y, x) && !visited[y][x] && board[y][x] == 0;
	}
	
	public static int count() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		Deque<int[]> dq = new ArrayDeque<>();
		
		for (int i = 0; i < n * m; i++) {
			int y = i / m;
			int x = i % m;
			
			if (board[y][x] != 0 && !visited[y][x]) {
				dq.offer(new int[] { y, x });
				cnt++;
				while (!dq.isEmpty()) {
					int[] xy = dq.poll();
					for (int j = 0; j < 4; j++) {
						int ny = xy[0] + dy[j];
						int nx = xy[1] + dx[j];
						if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] != 0) {
							dq.offer(new int[] { ny, nx });
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
		return cnt;
	}
	
	public static void melt() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		
		for (int i = 0; i < n * m; i++) {
			int y = i / m;
			int x = i % m;
			
			if (board[y][x] != 0) {
				int cnt = 0;
				visited[y][x] = true;
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if (isPossible(ny, nx, visited)) {
						cnt++;
					}
				}
				board[y][x] -= cnt;
				if (board[y][x] < 0) board[y][x] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int [n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while (true) {
			int ice = count();
			if (ice >= 2) break;
			if (ice <= 0) {
				cnt = 0;
				break;
			}
			melt();
			cnt++;
		}
		System.out.println(cnt);
	}
}
