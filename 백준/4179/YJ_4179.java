import java.util.*;
import java.io.*;

public class Main {
	
	static int r, c;
	static char[][] maze;
	static int[][] fireTime, jihunTime;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static Deque<int[]> fire;
	static Deque<int[]> jihun;
	
	public static boolean isValid(int y, int x) {
		return y >= 0 && y < r && x >= 0 & x < c;
	}
	
	public static boolean isPossible(int y, int x) {
		return isValid(y, x) && maze[y][x] == '.' && jihunTime[y][x] == -1;
	}
	
	public static void bfsFire() {
		while (!fire.isEmpty()) {
			int[] nowFire = fire.poll();
			int fy = nowFire[0];
			int fx = nowFire[1];
			
			for (int j = 0; j < 4; j++) {
				int ny = fy + dy[j];
				int nx = fx + dx[j];
				if (isValid(ny, nx) && maze[ny][nx] != '#' && fireTime[ny][nx] == -1) {
					fireTime[ny][nx] = fireTime[fy][fx] + 1;
					fire.offer(new int[] { ny, nx });
				}
			}
		}
	}
	
	public static int bfsRun() {
		while (!jihun.isEmpty()) {
			int[] nowjihun = jihun.poll();
			int jy = nowjihun[0];
			int jx = nowjihun[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = jy + dy[i];
				int nx = jx + dx[i];
				
				if (!isValid(ny, nx)) {
					return jihunTime[jy][jx] + 1;
				}
				if (isPossible(ny, nx)) {
					jihunTime[ny][nx] = jihunTime[jy][jx] + 1;
					if (fireTime[ny][nx] == -1 || jihunTime[jy][jx] + 1 < fireTime[ny][nx])
					jihun.offer(new int[] { ny, nx });
				}
			}
		}

		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		maze = new char[r][c];
		fireTime = new int[r][c];
		fire = new ArrayDeque<>();
		jihunTime = new int[r][c];
		jihun = new ArrayDeque<>();
		
		for (int i = 0; i < r; i++) {
			Arrays.fill(fireTime[i], -1);
			Arrays.fill(jihunTime[i], -1);
		}
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				maze[i][j] = str.charAt(j);
				if (maze[i][j] == 'J') {
					jihun.offer(new int[] { i, j });
					jihunTime[i][j] = 0;
				}
				if (maze[i][j] == 'F') {
					fire.offer(new int[] { i, j });
					fireTime[i][j] = 0;
				}
			}
		}
		
		bfsFire();
		int result = bfsRun();
		if (result == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(result);
	}
}
