public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            int u = read(), v = read();
            dist[u][v] = -1;
            dist[v][u] = 1;
        }
        for (int p = 1; p < n + 1; p++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++)
                    if (dist[i][p] != 0 && dist[i][p] == dist[p][j])
                        dist[i][j] = dist[i][p];
        int s = read();
        StringBuilder sb = new StringBuilder();
        while (s-- > 0) {
           sb.append(dist[read()][read()]).append("\n");
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
