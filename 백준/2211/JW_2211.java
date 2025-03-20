import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static ArrayList<ArrayList<int[]>> edges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        for (int i = 0; i < n + 1; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            edges.get(u).add(new int[] { u, v, w });
            edges.get(v).add(new int[] { v, u, w });
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[] visited = new boolean[n + 1];
        pq.offer(new int[] { 0, 1, 0 });
        visited[1] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(n - 1).append("\n");
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!visited[cur[1]]) {
                visited[cur[1]] = true;
                sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
            }
            for (int[] next : edges.get(cur[1])) {
                if (dist[next[1]] > dist[cur[1]] + next[2]) {
                    dist[next[1]] = dist[cur[1]] + next[2];
                    pq.offer(new int[] { next[0], next[1], dist[next[1]] });
                }
            }
        }
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
