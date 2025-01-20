import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int totalTurn = 0, size = 2, cnt = 0;
    static int sharkY, sharkX;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = { -1, 0, 1, 0 }, dx = { 0, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int p = read();
                if (p == 9) {
                    sharkY = i;
                    sharkX = j;
                } else
                    board[i][j] = p;
            }
        // 먹이를 먹지 못할 때까지 반복
        while (bfs(sharkY, sharkX)) {
            cnt++; // 먹은 횟수 증가
            // 몸집이 증가하는 조건
            if (cnt == size) {
                size++;
                cnt = 0;
            }
        }
        System.out.println(totalTurn);
    }

    private static boolean bfs(int sy, int sx) {
        // 먹이의 우선 순위
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Deque<int[]> dq = new ArrayDeque<>();
        visited = new boolean[n][n];
        dq.offer(new int[] { sy, sx }); // 초기 상어의 위치
        visited[sy][sx] = true;
        int turn = 0; // 움직인 횟수(깊이)
        while (!dq.isEmpty()) {
            turn++; // 움직인 횟수 증가
            int t = dq.size();
            while (t-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    // 움직일 수 있다면 다음 BFS 진행
                    if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] <= size) {
                        // 먹을 수 있다면
                        if (board[ny][nx] != 0 && board[ny][nx] < size)
                            pq.offer(new int[] { ny, nx });
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true;
                    }
                }
            }
            // 먹을 수 있는 먹이가 있다면,
            if (!pq.isEmpty()) {
                int[] shark = pq.poll(); // 우선 순위가 가장 높은 먹이를 꺼냄
                // 상어 위치를 먹이 위치로 변경
                sharkY = shark[0];
                sharkX = shark[1];
                board[sharkY][sharkX] = 0; // 냠냠
                totalTurn += turn; // 전체 움직인 횟수 증가
                return true;
            }
        }
        return false; // 먹이를 먹지 못했을 경우
    }
  
    // 경계 체크
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
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
