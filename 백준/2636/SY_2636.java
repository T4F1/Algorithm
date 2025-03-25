import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[][] board, visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1"))
					board[i][j] = true;
			}
		}

		int cnt = countCheese();
		int buffer = cnt;
		int repeat = 0;
		while (cnt != 0) {
			buffer = cnt;
			bfs();
			cnt = countCheese();
			repeat++;
		}

		System.out.println(repeat + "\n" + buffer);

	}

	public static void bfs() {
		boolean[][] nb = deepCopy(board);

		visited = new boolean[N][M];
		Deque<int[]> dq = new ArrayDeque<>();

		dq.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[1] + dx[i];
				int ny = now[0] + dy[i];

				if (isValid(nx, ny) && !visited[ny][nx]) {
					visited[ny][nx] = true;

					if (isTeduri(nx, ny)) {
						nb[ny][nx] = false;
					}

					if (!board[ny][nx]) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}

				}
			}
		}

		board = nb;
	}

	public static boolean[][] deepCopy(boolean[][] board) {
		boolean[][] nb = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				nb[i][j] = board[i][j];
			}
		}

		return nb;
	}

	public static boolean isValid(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}

	public static boolean isTeduri(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (isValid(nx, ny)) {
				if (!board[ny][nx])
					return true;
			} else {
				return true;
			}
		}

		return false;
	}

	public static int countCheese() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j])
					cnt++;
			}
		}

		return cnt;
	}
}
