public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            dist[i] = read();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++)
            cost[i] = read();
        long total = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            minCost = Math.min(minCost, cost[i]);
            total += (long) minCost * dist[i];
        }
        System.out.println(total);
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