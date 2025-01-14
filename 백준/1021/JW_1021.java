import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            dq.offerLast(i);
        int total = 0;
        for (int i = 0; i < m; i++) {
            int target = read();
            int cnt = 0;
            while (!dq.isEmpty() && target != dq.peekFirst()) {
                dq.offerLast(dq.pollFirst());
                cnt++;
            }
            total += Math.min(cnt, dq.size() - cnt);
            dq.pollFirst();
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
