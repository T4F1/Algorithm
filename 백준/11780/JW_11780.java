import java.util.Arrays;

public class Main {

    static final int INF = 10_001;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] dist = new int[n + 1][n + 1];
        int[][] tracking = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            dist[u][v] = Math.min(dist[u][v], w);
            tracking[u][v] = v;
        }
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        tracking[i][j] = tracking[i][k];
                    }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] == INF)
                    sb.append("0");
                else
                    sb.append(dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j || dist[i][j] == INF) {
                    sb.append("0\n");
                    continue;
                }
                StringBuilder path = new StringBuilder();
                int cnt = 1;
                path.append(i).append(" ");
                int now = i;
                while (now != j) {
                    path.append(tracking[now][j]).append(" ");
                    now = tracking[now][j];
                    cnt++;
                }
                sb.append(cnt).append(" ").append(path).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
