import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), k = read();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            int u = read();
            pq.offer(new int[] { u, 0 });
        }
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]])
                continue;
            visited[cur[0]] = true;
            totalWeight += cur[1];
            for (int[] next : adj.get(cur[0])) {
                if (!visited[next[0]])
                    pq.offer(next);
            }
        }
        System.out.println(totalWeight);
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
