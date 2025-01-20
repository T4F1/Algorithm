import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 불 {
    static char[][] arr;
    static int R, C;
    static Deque<int[]> jq = new ArrayDeque<>();
    static Deque<int[]> fq = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0}; // 세로(행) 이동 방향
    static int[] dy = {0, 0, -1, 1}; // 가로(열) 이동 방향

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        // 입력 받기
        for (int i = 0; i < R; i++) {
            char[] toCharArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                char c = toCharArray[j];
                if (c == 'J') {
                    jq.add(new int[]{i, j}); // 지훈 위치
                }
                if (c == 'F') {
                    fq.add(new int[]{i, j}); // 불 위치
                }
                arr[i][j] = c;
            }
        }

        int time = 0;

        // BFS 시작
        while (!jq.isEmpty()) {
            // 1. 불 확산
            int fsize = fq.size();
            for (int i = 0; i < fsize; i++) {
                int[] firePos = fq.poll();
                fire(firePos[0], firePos[1]);
            }
            //현재 단계의 요소만 처리하기 위해 size 를 미리 밖에다가 빼둠.
            // 2. 지훈 이동
            int jsize = jq.size();
            for (int m = 0; m < jsize; m++) {
                int[] j = jq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = j[0] + dx[i];
                    int ny = j[1] + dy[i];

                    // 탈출 성공
                    if (!isValid(nx, ny)) {
                        System.out.println(time + 1);
                        return;
                    }

                    // 이동 가능하면 이동
                    if (arr[nx][ny] == '.') {
                        arr[nx][ny] = 'J';
                        jq.add(new int[]{nx, ny});
                    }
                }
            }
            // 시간 증가
            time++;
        }

        // 탈출 불가능
        System.out.println("IMPOSSIBLE");
    }

    private static void fire(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 유효하지 않은 좌표는 건너뜀
            if (!isValid(nx, ny)) {
                continue;
            }

            // 불 확산 가능하면 확산
            if (arr[nx][ny] == '.' || arr[nx][ny] == 'J') {
                arr[nx][ny] = 'F';
                fq.add(new int[]{nx, ny});
            }
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}

