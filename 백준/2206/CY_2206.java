import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {

    static int n, m;
    static int[][] map;
    static boolean[][][] visited; // [벽을 부수었는지][x][y]
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2]; // [벽 부수었는지 여부][x][y]
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, false, 1)); // (벽을 부수었는지 여부, x, y)
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == n - 1 && point.y == m - 1) {
                return point.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (point.destroyed) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][1]) { // 벽이 아닌 곳
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, true, point.cnt + 1));
                    }
                } else {
                    if (map[nx][ny] == 1) {
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, true, point.cnt + 1));
                    } else if (!visited[nx][ny][0]) { //벽이 아니고 방문한적이 없으면 큐에 넣는다.
                        visited[nx][ny][0] = true;
                        q.offer(new Point(nx, ny, false, point.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        boolean destroyed;
        int cnt;

        public Point(int x, int y, boolean destroyed, int cnt) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.cnt = cnt;
        }
    }
}

