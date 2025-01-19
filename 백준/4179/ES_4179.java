import java.io.*;
import java.util.*;

public class ES_4179 {
    static int r, c;
    static int[][] fireMap; // 불의 확산 시간
    static int[][] jMap; // 지훈이의 이동 시간
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> fireQ = new ArrayDeque<>();
    static int startX, startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        fireMap = new int[r][c];
        jMap = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(fireMap[i], Integer.MAX_VALUE); // 방문하지 않음
            Arrays.fill(jMap[i], -1); // 방문하지 않음
        }

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireMap[i][j] = 0; // 불의 시작 위치
                } else if (map[i][j] == 'J') {
                    startX = i;
                    startY = j;
                    jMap[i][j] = 0; // 지훈 시작 위치
                } else if (map[i][j] == '#') {
                    fireMap[i][j] = -1; // 벽
                }
            }
        }

        fired();
        escape();
    }

    private static void fired() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && fireMap[nx][ny] == Integer.MAX_VALUE) {
                    fireMap[nx][ny] = fireMap[x][y] + 1;
                    fireQ.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void escape() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 가장자리에서 탈출
            if (isEdge(x, y)) {
                System.out.println(jMap[x][y] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 벽도 아니고, 지훈이가 방문하지 않은 곳일 때
                if (isValid(nx, ny) && fireMap[x][y] != -1 && jMap[nx][ny] == -1) {
                    // 지훈이가 불보다 먼저 도달할 수 있는 경우만 이동
                    if (jMap[x][y] + 1 < fireMap[nx][ny]) {
                        jMap[nx][ny] = jMap[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    // 유효한 좌표인지 확인
    static boolean isValid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    // 가장자리인지 확인
    static boolean isEdge(int x, int y) {
        return x == 0 || x == r - 1 || y == 0 || y == c - 1;
    }
}