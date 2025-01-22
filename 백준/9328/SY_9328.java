import java.util.*;
import java.io.*;

public class Main {
	static int H, W;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Set<Character> keys;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()) + 2;
			W = Integer.parseInt(st.nextToken()) + 2;
			map = new char[H][W];
			visited = new boolean[H][W];

			for (int i = 0; i < W; i++) {
				map[0][i] = '.';
				map[H - 1][i] = '.';
			}

			for (int i = 1; i < H - 1; i++) {
				map[i][0] = '.';
				map[i][W - 1] = '.';
				char[] input = br.readLine().toCharArray();
				for (int j = 1; j < W - 1; j++)
					map[i][j] = input[j - 1];
			}

			char[] keySet = br.readLine().toCharArray();
			keys = new HashSet<>();
			for (char key : keySet)
				keys.add(key);

			sb.append(bfs(0, 0)).append("\n");
		}

		System.out.println(sb);
	}

	public static int bfs(int y, int x) {
		int cnt = 0;
		Deque<int[]> dq = new ArrayDeque<>();

		if (isDoor(y, x) && canOpenWithKeys(y, x)) {
			dq.offer(new int[] { y, x });
			map[y][x] = '.';
			visited[y][x] = true;
		} else if (isKey(y, x)) {
			keys.add(map[y][x]);
			map[y][x] = '.';
			dq.offer(new int[] { y, x });
			visited[y][x] = true;
		} else if (!isDoor(y, x) && isValid(y, x)) {
			dq.offer(new int[] { y, x });
			visited[y][x] = true;
		}

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			if (isDoc(now[0], now[1])) {
				cnt++;
				map[now[0]][now[1]] = '.';
			}

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (isValid(ny, nx) && !visited[ny][nx]) {

					if (map[ny][nx] == 'B') {
						System.out.print("");
					}

					if (isDoor(ny, nx) && canOpenWithKeys(ny, nx)) {
						dq.offer(new int[] { ny, nx });
						map[ny][nx] = '.';
						visited[ny][nx] = true;
					} else if (isKey(ny, nx)) {
						keys.add(map[ny][nx]);
						initVisited();
						map[ny][nx] = '.';
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					} else if (!isDoor(ny, nx)) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}

		}

		return cnt;
	}

	public static void initVisited() {
		for (int i = 0; i < H * W; i++) {
			int y = i / W;
			int x = i % W;
			visited[y][x] = false;
		}
	}

	public static boolean isEdge(int y, int x) {
		return y == 0 || y == H - 1 && x == 0 || x == W - 1;
	}

	public static boolean isValid(int y, int x) {
		return 0 <= y && y < H && 0 <= x && x < W && map[y][x] != '*';
	}

	public static boolean isDoor(int y, int x) {
		return Character.isUpperCase(map[y][x]);
	}

	public static boolean isKey(int y, int x) {
		return Character.isLowerCase(map[y][x]);
	}

	public static boolean canOpenWithKeys(int y, int x) {
		char key = Character.toLowerCase(map[y][x]);
		return keys.contains(key);
	}

	public static boolean isDoc(int y, int x) {
		return map[y][x] == '$';
	}
}
