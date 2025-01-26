import java.util.*;
import java.io.*;

public class Main {

	static int n, sharkY, sharkX, sharkSize, fishCnt, time;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
	
	public static boolean bfs() {
		// int[] : y좌표, x좌표, 총 거리 저장
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
				return o1[2] - o2[2];
			}
		});

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { sharkY, sharkX, 0 });
		visited = new boolean[n][n];
		visited[sharkY][sharkX] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int y = now[0];
			int x = now[1];
			int t = now[2];				

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] <= sharkSize) {
					visited[ny][nx] = true;
					dq.offer(new int[] { ny, nx, t + 1 });
					if (board[ny][nx] != 0 && board[ny][nx] < sharkSize) {
						pq.add(new int[] { ny, nx, t + 1 });
					}
				}
			}
			
		}
		
		if (!pq.isEmpty()) {
			int[] fish = pq.poll();
			int fy = fish[0];
			int fx = fish[1];
			time += fish[2];
			fishCnt++;
			board[fy][fx] = 0;
			sharkY = fy;
			sharkX = fx;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		sharkY = 0;
		sharkX = 0;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					sharkY = i;
					sharkX = j;
					board[i][j] = 0;
				}
			}
		}
		
		sharkSize = 2;
		time = 0;
		fishCnt = 0;
		while (bfs()) {
			if (sharkSize == fishCnt) {
				sharkSize++;
				fishCnt = 0;
			}
		}
		
		System.out.println(time);
	}
}
