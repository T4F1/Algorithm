public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            arr[i] = read() + arr[i - 1];
        int len = read();
        int[][] dp = new int[4][n + 1];
        for (int i = 1; i <= 3; i++)
            for (int j = i * len; j < n + 1; j++)
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - len] + arr[j] - arr[j - len]);
        System.out.println(dp[3][n]);
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