import java.io.*;
import java.util.*;

public class ES_11780 {
    static final int INF = 100_000_000;
    static int n, m;
    static int[][] dist, path;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());

        dist = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
                path[a][b] = a;
            }
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) sb.append("0 ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || dist[i][j] == INF) {
                    sb.append("0\n");
                } else {
                    List<Integer> path = new ArrayList<>();
                    getPath(i, j, path);
                    sb.append(path.size()).append(" ");
                    for (int node : path) {
                        sb.append(node).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
    }

    private static void getPath(int start, int end, List<Integer> path) {
        if (start == end) {
            path.add(start);
            return;
        }
        getPath(start, ES_11780.path[start][end], path);
        path.add(end);
    }
}
