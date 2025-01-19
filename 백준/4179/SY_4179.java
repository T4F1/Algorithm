import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static int[][] fireMap;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int startX = 0, startY = 0;
		fireMap = new int[R][C];
		PriorityQueue<int[]> fireQueue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (input[j] == '#') {
					fireMap[i][j] = -1;
				} else if (input[j] == 'F') {
					fireQueue.offer(new int[] { i, j, 1 });
					fireMap[i][j] = 1;
				} else if (input[j] == 'J') {
					startY = i;
					startX = j;
				}
			}
		}

		int rst = run(startY, startX, fireQueue);
		if (rst < 0)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(rst);
	}

	public static int run(int y, int x, PriorityQueue<int[]> fireQueue) {
		if (isSurvivable(y, x)) {
			return 1;
		}

		spreadFire(fireQueue);

		boolean[][] visited = new boolean[R][C];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x, 1 });
		visited[y][x] = true;

		boolean survived = false;
		while (!dq.isEmpty() && !survived) {
			int[] now = dq.poll();

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (isValid(ny, nx) && !visited[ny][nx] && (fireMap[ny][nx] > now[2] + 1 || fireMap[ny][nx] == 0)) {
					dq.offer(new int[] { ny, nx, now[2] + 1 });
					visited[ny][nx] = true;

					if (isSurvivable(ny, nx)) {
						return now[2] + 1;
					}
				}
			}
		}

		return -1;
	}

	public static void spreadFire(PriorityQueue<int[]> fireQueue) {
		while (!fireQueue.isEmpty()) {
			int[] now = fireQueue.poll();
			for (int j = 0; j < 4; j++) {
				int ny = now[0] + dy[j];
				int nx = now[1] + dx[j];
				if (isValid(ny, nx) && fireMap[ny][nx] == 0) {
					fireQueue.offer(new int[] { ny, nx, now[2] + 1 });
					fireMap[ny][nx] = now[2] + 1;
				}
			}
		}
	}

	public static boolean isSurvivable(int y, int x) {
		return 0 == y || y == R - 1 || 0 == x || x == C - 1;
	}

	public static boolean isValid(int y, int x) {
		return 0 <= y && y < R && 0 <= x && x < C && fireMap[y][x] != -1;
	}

}
