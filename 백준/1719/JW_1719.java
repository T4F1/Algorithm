import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        int n = read(), m = read();
        int[][] adj = new int[n + 1][n + 1];
        int[][] tracking = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(adj[i], Integer.MAX_VALUE >> 2);
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            w = Math.min(adj[u][v], w);
            adj[u][v] = w;
            adj[v][u] = w;
            tracking[u][v] = v;
            tracking[v][u] = u;
        }
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++)
                    if (adj[i][k] + adj[k][j] < adj[i][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                        tracking[i][j] = tracking[i][k];
                    }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++)
                sb.append(i != j ? tracking[i][j] : "-").append(' ');
            sb.append('\n');
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
