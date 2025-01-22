import java.io.*;
import java.util.*;

public class ES_2206 {
    static boolean[][] map;
    static boolean[][][] visited; // {x,y,벽이 뚫렸을 때} // 0은 안뚫렸을 때, 1은 뚫렸을 때
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String[] tmp = in.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp[j].equals("0");
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0,false, 1)); // [x,y,벽 부숨 여부,이동 횟수]
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            boolean broke = cur.broke;
            int brokeIndex = broke ? 1 : 0;
            int cnt = cur.cnt;

            if (x == n - 1 && y == m - 1) {
                answer = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny)) {
                    // 벽 없고 방문하지 않았을 경우
                    if (map[nx][ny] && !visited[nx][ny][brokeIndex]) {
                        visited[nx][ny][brokeIndex] = true;
                        q.offer(new Point(nx,ny,broke, cnt+1));
                    }
                    // 현재 좌표가 벽일 때
                    else if(!map[nx][ny] && !broke && !visited[nx][ny][brokeIndex]) {
                        visited[nx][ny][brokeIndex] = true;
                        q.offer(new Point(nx,ny,true,cnt+1));
                    }
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Point{
        int x;
        int y;
        boolean broke;
        int cnt;

        Point(int x, int y, boolean broke, int cnt){
            this.x = x;
            this.y = y;
            this.broke = broke;
            this.cnt = cnt;
        }
    }
}
