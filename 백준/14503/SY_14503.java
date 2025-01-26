import java.util.*;
import java.io.*;

public class Main {
	static int N, M, d;
	static boolean[][] room, visited;
	// 북, 동, 남, 서
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		room = new boolean[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				room[i][j] = st.nextToken().equals("1") ? false : true;
			}
		}
		
		System.out.println(work(r, c));
	}
	
	public static int work(int y, int x) {
		int cnt = 0;
		int ny = y;
		int nx = x;
		while(true) {
			// 청소가 되지 않은 경우
			if(!visited[ny][nx]) {
				cnt++;
				visited[ny][nx] = true;
			}
			
			// 주변 칸 탐색 -> 바라보고 있는 방향 기준으로 반시계 방향으로 회전하
			boolean search = false;
			for(int i = 0; i < 4; i++) {
				turn();
				int nextY = ny + dy[d];
				int nextX = nx + dx[d];
				if(isValid(nextY, nextX) && !visited[nextY][nextX]) {
					ny = nextY;
					nx = nextX;
					search = true;
					break;
				}
			}
			
			// 못찾았다면..
			if(!search) {
				int nextY = ny + dy[back(d)];
				int nextX = nx + dx[back(d)];
				if(isValid(nextY, nextX)) {
					ny = nextY;
					nx = nextX;
				} else {
					break;
				}
			}
			
		}
		
		return cnt;
	}
	
	public static boolean isValid(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M && room[y][x];
	}
	
	public static void turn() {
		d--;
		if(d < 0) d += 4;
	}
	
	public static int back(int d) {
		if(d == 0) return 2;
		else if(d == 1) return 3;
		else if(d == 2) return 0;
		return 1;
	}
	
}
