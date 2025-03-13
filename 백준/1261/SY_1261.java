import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt = Integer.MAX_VALUE;
	static char[][] board;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[M][N];
		visited = new int[M][N];

		for (int i = 0; i < M; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = input[j];
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs();

		System.out.println(cnt);
	}

	public static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 0 });
		visited[0][0] = 0;

		while (!dq.isEmpty()) {
			int[] p = dq.poll();
			int x = p[0];
			int y = p[1];

			if (x == N - 1 && y == M - 1) {
				cnt = Math.min(cnt, p[2]);
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				int a = 0;
				if (isValid(nx, ny) && board[ny][nx] == '1')
					a = 1;

				if (isValid(nx, ny) && visited[ny][nx] > p[2] + a) {
					visited[ny][nx] = p[2] + a;
					dq.offer(new int[] { nx, ny, p[2] + a });
				}
			}
		}
	}

	public static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}
