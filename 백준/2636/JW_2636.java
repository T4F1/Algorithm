import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, m;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        board = new boolean[n][m];
        int total = 0, time = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (read() == 1) {
                    board[i][j] = true;
                    total++;
                }
        while (total > 0) {
            time++;
            int cnt = 0;
            visited = new boolean[n][m];
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] {0, 0});
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                for (int i = 0; i < 4; i++) {
                    int y = cur[0] + dy[i];
                    int x = cur[1] + dx[i];
                    if (isValid(y, x)) {
                        if (!board[y][x]) {
                            dq.offer(new int[] {y, x});
                        } else {
                            board[y][x] = false;
                            cnt++;
                        }
                        visited[y][x] = true;
                    }
                }
            }
            if (total - cnt == 0) {
                System.out.println(time);
                System.out.println(cnt);
                return;
            } else
                total -= cnt;
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m && !visited[y][x];
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
