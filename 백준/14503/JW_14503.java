public class Main {

    static int n, m;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        int sy = read(), sx = read(), d = read();
        board = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = read() == 0;
        dfs(sy, sx, d); // DFS 시작
        System.out.println(cnt);
    }

    // 로봇 청소기의 움직임을 DFS로 구현
    private static void dfs(int y, int x, int d) {
        // 종료 조건
        if (!isValid(y, x) || !board[y][x])
            return;
        // 청소되지 않은 타일은 청소
        if (!visited[y][x]) {
            visited[y][x] = true;
            cnt++;
        }
        int dir = d;
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 90도 회전
            int ny = y + dy[dir], nx = x + dx[dir];
            // 청소되지 않은 타일이 존재한다면
            if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx]) {
                dfs(ny, nx, dir);
                return;
            }
        }
        // 방향은 유지하고 뒤로 이동
        dfs(y - dy[d], x - dx[d], d);
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
