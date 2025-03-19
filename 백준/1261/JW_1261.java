import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] board;
    static int[][] visited;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = line.charAt(j) == '0';
        }
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, 0, 0 });
        visited[0][0] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1], t = cur[2];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx)) {
                    if (board[ny][nx] && visited[ny][nx] > t) {
                        visited[ny][nx] = t;
                        dq.offer(new int[] { ny, nx, t });
                    } else if (!board[ny][nx] && visited[ny][nx] > t + 1) {
                        visited[ny][nx] = t + 1;
                        dq.offer(new int[] { ny, nx, t + 1 });
                    }
                }
            }
        }
        System.out.println(visited[n - 1][m - 1]);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
