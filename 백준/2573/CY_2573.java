
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 빙산 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int arr[][];
    static boolean[][] visited;
    static int N, M, year = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int idx = Integer.parseInt(st.nextToken());
                arr[i][j] = idx;
            }
        }
        while (true) {
            int block = countIce();
            if (block >= 2) {
                break;
            } else if (block == 0) {
                year = 0;
                break;
            }
            meltIce();
            year++;
        }
        System.out.println(year);
    }

    private static void meltIce() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int ice = arr[i][j];
                int count = 0;
                for (int move = 0; move < 4; move++) {
                    int nr = i + dx[move];
                    int nc = j + dy[move];
                    if (isValid(nr, nc) && arr[nr][nc] == 0) {
                        count++;
                    }
                }
                ice -= count;
                temp[i][j] = Math.max(ice, 0);
            }
        }
        arr = temp;
    }

    private static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    private static int countIce() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {//덩어리 발견
                    bfs(i, j); //근처 덩어리 탐색
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, y});
        visited[x][y] = true;
        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny) && !visited[nx][ny] && arr[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    dq.offer(new int[]{nx, ny});
                }
            }
        }
    }
}