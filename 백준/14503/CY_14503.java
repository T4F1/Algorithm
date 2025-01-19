import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int r, c, dir;
    static int cnt = 0;

    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        System.out.println(cnt);
    }

    private static void simulate() {
        while (true) {
            // 1. 현재 위치 청소
            if (!visited[r][c]) {
                visited[r][c] = true;
                cnt++;
            }

            boolean flag = false;

            // 2. 현재 방향 기준으로 왼쪽부터 탐색
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4; // 반시계 방향 회전
                int nr = r + dx[dir];
                int nc = c + dy[dir];

                if (arr[nr][nc] == 0 && !visited[nr][nc]) {// 청소되지 않은 빈 칸으로 이동
                    r = nr;
                    c = nc;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                // 3. 네 방향 모두 청소되었거나 벽인 경우
                int backDir = (dir + 2) % 4; // 후진 방향
                int nr = r + dx[backDir];
                int nc = c + dy[backDir];

                if (arr[nr][nc] == 1) {  // 뒤쪽이 벽이면 종료
                    return;
                } else {// 후진
                    r = nr;
                    c = nc;
                }
            }
        }
    }
}

