import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int n, m;
	static int[][] cheese;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
	
	static void find() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0 });
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int nowY = now[0];
			int nowX = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nextY = nowY + dy[i];
				int nextX = nowX + dx[i];
				if (isValid(nextY, nextX) && !visited[nextY][nextX]) {
					if (cheese[nextY][nextX] == 0) {
						visited[nextY][nextX] = true;
						dq.offer(new int[] { nextY, nextX });
					}
					if (cheese[nextY][nextX] == 1) {
						visited[nextY][nextX] = true;
						cheese[nextY][nextX] = 2;
					}
				}
			}
		}
	}
	
	static void melt() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cheese[i][j] == 2) cheese[i][j] = 0;
			}
		}	
	}
	
	static int count() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cheese[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		cheese = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cheese[i][j] = read();
			}
		}
		
		int time = 0;
		int cnt = count();
		while (true) {
			find();
			time++;
			melt();
			if (count() == 0) break;
			cnt = count();
		}
		System.out.println(time + "\n" + cnt);
	}
}
