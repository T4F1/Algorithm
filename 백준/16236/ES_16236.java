import java.io.*;
import java.util.*;

public class ES_16236 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, answer = 0;
    static int sharkSize = 2;
    static int eatCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            int[] point = bfs(startX, startY);
            if(point == null)
                break;

            int x = point[0];
            int y = point[1];
            int cnt = point[2];

            // 물고기 먹음 표시
            answer += cnt;
            map[x][y] = 0;
            eatCnt ++;

            if(eatCnt == sharkSize){
                sharkSize++;
                eatCnt = 0;
            }

            startX = x;
            startY = y;
        }
        System.out.println(answer);
    }

    private static int[] bfs(int startX, int startY) {
        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[n][n];
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        List<int[]> fish = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && canMove(nx, ny)) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny,cnt+1});
                    // 먹을 수 있는지 확인 
                    if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                        fish.add(new int[]{nx,ny,cnt+1});
                    }
                }
            }
        }

        return getNearestFish(fish);
    }

    private static int[] getNearestFish(List<int[]> fish) {
        if(fish.isEmpty())
            return null;
        // 좌표가 더 가까운 것을 먼저 함
        fish.sort((a, b) -> {
            if(a[2] == b[2]) {
                if(a[0] == b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
            return a[2]-b[2];
        });

        return fish.get(0);
    }

    private static boolean canMove(int nx, int ny) {
        return map[nx][ny] <= sharkSize;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
