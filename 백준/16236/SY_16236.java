import java.util.*;
import java.io.*;

public class Main {
	static int N, size = 2;
	static int[][] sea, dis;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		dis = new int[N][N];
		int y = 0, x = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) { // 상어 위치 찾기
					sea[i][j] = 0;
					y = i;
					x = j;
				}
			}
		}

		System.out.println(moveBabyShark(y, x));
	}

	public static int moveBabyShark(int y, int x) {
		size = 2;
		int time = 0;
		int fishCnt = 0;
		int startY = y;
		int startX = x;
		while (true) {
			int[] now = bfs(startY, startX);
			if (now == null)
				break;

			int ny = now[0];
			int nx = now[1];
			time += now[2];

			sea[ny][nx] = 0;
			fishCnt++;

			if (fishCnt == size) {
				fishCnt = 0;
				size++;
			}
			
			startY = now[0];
			startX = now[1];
		}
		
		

		return time;
	}

	public static int[] bfs(int y, int x) {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] != o2[2])
				return o1[2] - o2[2];
			if (o1[0] != o2[0])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x, 0 });
		visited[y][x] = true;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (isPassable(ny, nx) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					// 먹을 수 있는건 따로 담기
					if (isEdible(ny, nx))
						pq.offer(new int[] { ny, nx, now[2] + 1 });
					// 이와 별개로 지나갈 수 있는 얘도 따로 담기
					dq.offer(new int[] { ny, nx, now[2] + 1 });
				}
			}
		}

		if (pq.isEmpty())
			return null;
		return pq.poll();
	}

	public static boolean isValid(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	public static boolean isEdible(int y, int x) {
		return isValid(y, x) && sea[y][x] < size && sea[y][x] != 0;
	}

	public static boolean isPassable(int y, int x) {
		return isValid(y, x) && sea[y][x] <= size;
	}
}
