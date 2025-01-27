public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            max = Math.max(max, arr[i]);
        }
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int i = 1; i <= 3; i++)
            for (int j = i; j <= max; j++)
                dp[j] += dp[j - i];
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(dp[i]).append("\n");
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