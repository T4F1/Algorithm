import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> nq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i++) {
            int num = read();
            if (num > 0)
                pq.add(num);
            else
                nq.add(num);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (!pq.isEmpty() && num + pq.peek() < num * pq.peek())
                sum += num * pq.poll();
            else
                sum += num;
        }
        while (!nq.isEmpty()) {
            int num = nq.poll();
            if (!nq.isEmpty())
                sum += num * nq.poll();
            else
                sum += num;
        }
        System.out.println(sum);
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