import java.io.*;
import java.util.*;

public class ES_2211 {
    static List<List<int[]>> graph;
    static int[] distances, lines;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        lines = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            lines[i] = i;
        }

        dijkstra(1);

        int cnt = 0;
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != lines[i]) {
                cnt++;
                result.add(i + " " + lines[i]);
            }
        }

        System.out.println(cnt);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, start});
        distances[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int now = cur[1];

            if (distances[now] < dist) continue;

            for (int[] next : graph.get(now)) {
                int cost = dist + next[1];
                if (cost < distances[next[0]]) {
                    distances[next[0]] = cost;
                    lines[next[0]] = now;
                    pq.offer(new int[]{cost, next[0]});
                }
            }
        }
    }
}
