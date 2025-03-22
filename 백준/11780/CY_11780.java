import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11780 {
    static int N, M = 0;
    static int[][] dist;
    static int[][] location;
    static int MAX = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        location = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = MAX;
                }
                location[i][j] = 0; // 경유지 초기화는 0
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[start][to] = Math.min(dist[start][to], cost);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                        continue;
                    }
                    if (dist[i][k] == MAX || dist[k][j] == MAX) {
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        location[i][j] = k; // 경유지 기록
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // i->j로 가는데 필요한 최소비용
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append("0").append("\n");
                } else {
                    List<Integer> path = new ArrayList<>();
                    getPath(i, j, path);
                    sb.append(path.size()).append(" ");
                    for (int p : path) {
                        sb.append(p).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void getPath(int start, int end, List<Integer> path) {
        if (location[start][end] == 0) {
            path.add(start);       // 경유지 없으면 바로 경로
            path.add(end);
        } else {
            int mid = location[start][end];
            getPath(start, mid, path);
            path.remove(path.size() - 1); // 중복 방지
            getPath(mid, end, path);
        }
    }
}
