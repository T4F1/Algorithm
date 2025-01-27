public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            arr[i] = read();
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = arr[i]; j < k + 1; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);
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