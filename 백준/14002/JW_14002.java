import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] dp = new int[n];
        int len = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--)
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    len = Math.max(len, dp[i]);
                }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--)
            if (dp[i] == len) {
                dq.offerLast(arr[i]);
                len--;
            }
        while (!dq.isEmpty())
            sb.append(dq.pollLast()).append(" ");
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