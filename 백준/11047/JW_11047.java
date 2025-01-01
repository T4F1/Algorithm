import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++)
            pq.offer(read());
        int total = 0;
        while (k > 0) {
            int unit = pq.poll();
            int cnt = k / unit;
            total += cnt;
            k -= unit * cnt;
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