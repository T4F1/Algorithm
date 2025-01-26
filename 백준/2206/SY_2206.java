import java.util.*;
import java.io.*;

public class Main {
	static int N, M, canBreak = 1;
	static boolean[][] board;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (input[j] == '0')
					board[i][j] = true;
				else
					board[i][j] = false;
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		if (N == 1 && M == 1)
			return 1;

		int[][] visited = new int[N][M];

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 1, 1 });
		visited[0][0] = 1;

		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			if (now[0] == N - 1 && now[1] == M - 1)
				return now[3];
			for (int i = 0; i < 4; i++) {
				int y = now[0] + dy[i];
				int x = now[1] + dx[i];

				if (y == N - 1 && x == M - 1)
					return now[3] + 1;

				if (isValid(y, x) && board[y][x] && visited[y][x] != 3) {
					if (visited[y][x] != 2 && now[2] == 0) {
						dq.offer(new int[] { y, x, now[2], now[3] + 1 });
						visited[y][x] += 2;
					} else if (visited[y][x] != 1 && now[2] == 1) {
						dq.offer(new int[] { y, x, now[2], now[3] + 1 });
						visited[y][x] += 1;
					}

				} else if (isValid(y, x) && !board[y][x] && now[2] == 1) {
					dq.offer(new int[] { y, x, 0, now[3] + 1 });
				}
			}

			if (dq.isEmpty()) {
				System.out.print("");
			}
		}

		return -1;
	}

	public static boolean isValid(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
