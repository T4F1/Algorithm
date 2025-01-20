import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = read();
        boolean flag = true; // BFS를 진행했는지 확인할 flag
        int turn = 0; // 연도
        // BFS를 진행하지 않을 때까지 반복
        while (flag) {
            flag = false; // flag 초기화
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    // 방문하지 않은 빙하 중에서,
                    if (!visited[i][j] && board[i][j] > 0) {
                        // 같은 연도에 이미 BFS를 진행했다면 두 덩어리 이상으로 나뉜 것
                        if (flag) {
                            System.out.println(turn);
                            return;
                        }
                        flag = true;
                        melt(bfs(i, j)); // BFS 진행 후, 높이 감소
                    }
            turn++;
        }
        System.out.println(0);
    }

    private static int[][] bfs(int sy, int sx) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx });
        visited[sy][sx] = true;
        int[][] melting = new int[n][m]; // 빙하가 녹는 양을 저장할 배열
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                // 방문하지 않은 곳들 중에서,
                if (isValid(ny, nx) && !visited[ny][nx]) {
                    // 빙하라면
                    if (board[ny][nx] > 0) {
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true; // 빙하 방문 처리
                    // 바닷물이라면
                    } else
                        melting[y][x]++; // 녹는 양 증가
                }
            }
        }
        return melting;
    }

    // 녹는 것 구현
    private static void melt(int[][] melting) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] -= melting[i][j];
    }

    // 경계 체크
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    // 빠른 입력 함수
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
