import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new boolean[r][c];
        visited = new boolean[r][c];
        Deque<int[]> dq = new ArrayDeque<>();
        int sy = 0, sx = 0; // 지훈이 초기 위치
        for (int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                int c = line[j];
                // 벽
                if (c == '#') {
                    board[i][j] = true;
                    visited[i][j] = true;
                // 지훈이
                } else if (c == 'J') {
                    sy = i;
                    sx = j;
                // 불
                } else if (c == 'F') {
                    board[i][j] = true;
                    dq.offer(new int[] { i, j, 1 });
                }
            }
        }
        dq.offer(new int[] { sy, sx, 0 }); // 지훈이 큐에 삽입
        int turn = 0;
        // BFS
        while (!dq.isEmpty()) {
            turn++; // 턴 증가
            int size = dq.size(); // 해당 턴에 움직일 수 있는 요소들의 수
            // BFS 진행
            while (size-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1], t = cur[2];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i]; // 다음 방향
                    if (isValid(ny, nx)) {
                        if (!board[ny][nx]) {
                            // 지훈이
                            if (t == 0) {
                                // 방문하지 않은 곳이라면
                                if (!visited[ny][nx]) {
                                    dq.offer(new int[] { ny, nx, t });
                                    visited[ny][nx] = true; // 방문처리
                                }
                            // 불
                            } else {
                                dq.offer(new int[] { ny, nx, t });
                                board[ny][nx] = true; // 불(벽) 확산
                            }
                        }
                    // 경계를 벗어난 경우에 지훈이라면
                    } else if (t == 0) {
                        System.out.println(turn);
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    // 경계 체크
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }
}
