public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++)
                dp[i][j] = read() + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
        int maxValue = Integer.MIN_VALUE;
        for (int y = 1; y < n + 1; y++)
            for (int x = 1; x < m + 1; x++)
                for (int ny = 0; ny < y; ny++)
                    for (int nx = 0; nx < x; nx++)
                        maxValue = Math.max(maxValue, dp[y][x] - dp[ny][x] - dp[y][nx] + dp[ny][nx]);
        System.out.println(maxValue);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}