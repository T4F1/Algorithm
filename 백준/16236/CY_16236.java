import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 아기_상어 {
    static int N, time, r, c, eat = 0, size = 2;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 공간 입력 및 초기 아기 상어 위치 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 9) {
                    r = i;
                    c = j;
                    arr[i][j] = 0; // 아기 상어 위치 초기화
                } else {
                    arr[i][j] = value;
                }
            }
        }
        while (true) {
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) :
                            o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

            visited = new boolean[N][N];
            q.add(new int[]{r, c, 0});
            visited[r][c] = true;

            boolean flag = false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cr = cur[0];
                int cc = cur[1];
                int dist = cur[2];

                // 먹을 수 있는 물고기를 찾은 경우
                if (arr[cr][cc] > 0 && arr[cr][cc] < size) {
                    arr[cr][cc] = 0; // 물고기 먹기
                    eat++; // 먹은 횟수 증가
                    time += dist; // 이동 시간 추가
                    r = cr; // 아기 상어 위치 갱신
                    c = cc;
                    flag = true;
                    break;
                }

                // 상하좌우 탐색
                for (int i = 0; i < 4; i++) {
                    int ny = cr + dy[i];
                    int nx = cc + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || arr[ny][nx] > size) {
                        continue;
                    }
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, dist + 1});
                }
            }

            if (!flag) {
                break; // 먹을 물고기가 더 이상 없으면 종료
            }

            if (eat == size) { // 아기 상어 크기 증가
                size++;
                eat = 0;
            }
        }

        System.out.println(time);
    }
}
