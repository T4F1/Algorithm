import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), w = read(), l = read();
        int[] truck = new int[n];
        for (int i = 0; i < n; i++)
            truck[i] = read();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < w; i++)
            dq.offerLast(0);
        int turn = 0, totalWeight = 0, idx = 0;
        while (!dq.isEmpty()) {
            turn++;
            totalWeight -= dq.pollFirst();
            if (idx < n)
                if (totalWeight + truck[idx] > l)
                    dq.offerLast(0);
                else {
                    dq.offer(truck[idx]);
                    totalWeight += truck[idx];
                    idx++;
                }
        }
        System.out.println(turn);
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
