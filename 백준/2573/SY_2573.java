import java.util.*;
import java.io.*;

public class Main {
	static int Y, X;
	static int[][] ice;
	static boolean[][] visited;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ice = new int[Y][X];
		visited = new boolean[Y][X];
		
		for(int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < X; j++)
				ice[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		while(true) {
			melt();
			cnt++;
			if(count() >= 2) break;
			
			boolean onlyZero = true;
			for(int i = 0; i < Y * X; i++) {
				int y = i / X;
				int x = i % X;
				if(ice[y][x] > 0) onlyZero = false;
			}
			if(onlyZero) {
				cnt = 0;
				break;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean isVaild(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
	
	public static boolean isSea(int y, int x) {
		return ice[y][x] == 0;
	}
	
	public static void initVisited() {
		for(int i = 0; i < Y * X; i++) {
			int y = i / X;
			int x = i % X;
			visited[y][x] = false;
		}
	}
	
	public static void melt() {
		initVisited();
		
		for(int i = 0; i < X * Y; i++) {
			int y = i / X;
			int x = i % X;
			
			if(!isSea(y, x)) { // 땅이라면
				// bfs 시작
				int cnt = 0;
				visited[y][x] = true;
				for(int j = 0; j < 4; j++) { // 상하좌우 옮기기
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					// 바다면 카운트하기
					if(isVaild(ny, nx) && isSea(ny, nx) && !visited[ny][nx]) {
						cnt++;
					}
				}
				
				ice[y][x] -= cnt;
				if(ice[y][x] < 0) ice[y][x] = 0;
			}
		}
		
	}
	
	public static int count() {
		initVisited();
		int cnt = 0;
		
		Deque<int[]> dq = new ArrayDeque<>();
		for(int i = 0; i < Y * X; i++) {
			int y = i / X;
			int x = i % X;
			dq.clear();
			if(!isSea(y, x) && !visited[y][x]) { // 빙산이면 BFS 시작
				cnt++;
				dq.add(new int[] {y, x});
				visited[y][x] = true;
				
				while(!dq.isEmpty()) {
					int[] xy = dq.poll();
					
					for(int j = 0; j < 4; j++) {
						int ny = xy[0] + dy[j];
						int nx = xy[1] + dx[j];
						// 빙산이라면 방문하기
						if(isVaild(ny, nx) && !isSea(ny, nx) && !visited[ny][nx]) {
							dq.add(new int[] {ny, nx});	
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
		
		return cnt;
	}
}
