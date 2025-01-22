import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int h, w, cnt;
    static char[][] board;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            board = new char[h + 2][w + 2]; // 테두리 확장
            cnt = 0;
            for (int i = 0; i < h + 2; i++)
                Arrays.fill(board[i], '.');
            for (int i = 1; i < h + 1; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 1; j < w + 1; j++)
                    board[i][j] = line[j - 1];
            }
            char[] keyArr = br.readLine().toCharArray();
            int keys = 0;
            for (char key : keyArr) {
                keys |= (1 << (key - 'a')); // 비트 연산
            }
            bfs(0, 0, keys);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int sy, int sx, int keys) {
        boolean[][] visited = new boolean[h + 2][w + 2];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx });
        visited[sy][sx] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx) && !visited[ny][nx]) {
                    char c = board[ny][nx];
                    // 기본적으로 이동할 수 있는 칸
                    if (c == '.' || c == '$') {
                        // 문서 훔치기
                        if (c == '$') {
                            board[ny][nx] = '.';
                            cnt++;
                        }
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true;
                    // 열쇠를 발견했을 경우
                    } else if (Character.isLowerCase(c)) {
                        // 처음 본 열쇠라면
                        if ((keys & (1 << (c - 'a'))) == 0) {
                            // 새로운 BFS 호출
                            bfs(ny, nx, (keys |= (1 << (c - 'a'))));
                            return;
                        }
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true;
                    // 해당 열쇠가 있는 문인 경우
                    } else if (Character.isUpperCase(c) && (keys & (1 << (c - 'A'))) != 0) {
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < h + 2 && 0 <= x && x < w + 2;
    }
}
