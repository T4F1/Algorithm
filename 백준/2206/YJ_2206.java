import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static char[][] board;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

	public static int bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 0 }); // y좌표, x좌표, 벽 부순 유무

		int[][][] visited = new int[n][m][2];
		visited[0][0][0] = 1;

		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int y = now[0];
			int x = now[1];
			int w = now[2];

			if (y == n - 1 && x == m - 1)
				return visited[y][x][w];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (isValid(ny, nx)) { // 범위 내에 존재하고
					if (board[ny][nx] == '0' && visited[ny][nx][w] == 0) { // 벽이 아니고, 방문하지 않았을 때
						visited[ny][nx][w] = visited[y][x][w] + 1;
						dq.offer(new int[] { ny, nx, w });
					} else if (board[ny][nx] == '1' && w == 0) {
						visited[ny][nx][w + 1] = visited[y][x][w] + 1; // 벽이고, 벽을 부수지 않았을 때
						dq.offer(new int[] { ny, nx, w + 1 });
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		System.out.println(bfs());
	}
}
