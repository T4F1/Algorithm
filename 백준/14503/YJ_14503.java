import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, cnt = 0;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dx = { 0, 1, 0, -1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
	
	static boolean isPossible(int y, int x) {
		return isValid(y, x) && board[y][x] == 0 && !visited[y][x];
	}
	
	public static void bfs(int y, int x, int d) {
		if (!visited[y][x]) {
			visited[y][x] = true;
			cnt++;
		}

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (isPossible(ny, nx)) {
				bfs(ny, nx, d);
				return;
			}
		}
		int backDir = (d + 2) % 4;
        int ny = y + dy[backDir];
        int nx = x + dx[backDir];

		if (isValid(ny, nx) && board[ny][nx] != 1) {
			bfs(ny, nx, d);
			return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		bfs(r, c, d);
		System.out.println(cnt);
	}
}
