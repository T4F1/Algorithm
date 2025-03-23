public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = read();
        int sumWeight = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j)
                    continue;
                int minWeight = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k)
                        continue;
                    minWeight = Math.min(minWeight, graph[i][k] + graph[k][j]);
                }
                if (minWeight < graph[i][j]) {
                    System.out.println(-1);
                    return;
                } else if (minWeight != graph[i][j])
                    sumWeight += graph[i][j];
            }
        }
        System.out.println(sumWeight);
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
