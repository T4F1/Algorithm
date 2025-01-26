import java.util.*;
import java.io.*;

public class Main {

	static int h, w, docCnt;
	static char[][] building;
	static boolean[][] visited;
	static List<int[]> exit;
	static List<Character> key;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };

	public static boolean isValid(int y, int x) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}

	public static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		visited = new boolean[h][w];

		for (int[] e : exit) {
			int y = e[0];
			int x = e[1];
			if (Character.isAlphabetic(building[y][x])) {
				if (Character.isUpperCase(building[y][x])) { // 문일 경우
					for (char k : key) {
						if (building[y][x] == k) {
							building[y][x] = '.';
							dq.offer(new int[] { y, x });
							visited[y][x] = true;
							break;
						}
					}
					if (dq.isEmpty()) continue;
				} else { // 열쇠일 경우
					key.add(Character.toUpperCase(building[y][x]));
					building[y][x] = '.';
				}
			} else if (building[y][x] == '$') { // 문서일 경우
				docCnt++;
				building[y][x] = '.';
				dq.offer(new int[] { y, x });
			} else { // 빈 공간일 경우
				dq.offer(new int[] { y, x });
				visited[y][x] = true;
			}
			
			while (!dq.isEmpty()) {
				int[] now = dq.poll();
				y = now[0];
				x = now[1];
				
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (isValid(ny, nx) && !visited[ny][nx] && building[ny][nx] != '*') {
						if (Character.isAlphabetic(building[ny][nx])) {
							if (Character.isLowerCase(building[ny][nx])) { // 열쇠일 경우
								key.add(Character.toUpperCase(building[ny][nx]));
								building[ny][nx] = '.';
								dq.offer(new int[] { ny, nx });
								visited[ny][nx] = true;
							} else if (Character.isUpperCase(building[ny][nx])) { // 문일 경우
								for (char k : key) {
									if (building[ny][nx] == k) {
										building[ny][nx] = '.';
										dq.offer(new int[] { ny, nx });
										visited[ny][nx] = true;
										break;
									}
								}
							}
						} else if (building[ny][nx] == '.') { // 문서일 경우
							dq.offer(new int[] { ny, nx });
							visited[ny][nx] = true;
						} else if (building[ny][nx] == '$') { // 빈 공간일 경우
							building[ny][nx] = '.';
							docCnt++;
							dq.offer(new int[] { ny, nx });
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			building = new char[h][w];
			exit = new ArrayList<>();
			key = new ArrayList<>();
			docCnt = 0;

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					building[i][j] = str.charAt(j);

					if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && building[i][j] != '*') {
						exit.add(new int[] { i, j });
					}
				}
			}

			String keys = br.readLine();
			for (int j = 0; j < keys.length(); j++) {
				char k = keys.charAt(j);
				if (Character.isAlphabetic(k))
					key.add(Character.toUpperCase(k)); // 열쇠 대문자로 저장
			}
			
			while (true) { // 새로운 열쇠가 추가되지 않을 때까지
				int keyCnt = key.size();
				bfs();
				if (keyCnt == key.size()) break;
			}
			
			System.out.println(docCnt);
		}
	}
}
