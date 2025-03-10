import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 행성_터널 {
    static int N = 0;
    static List<int[]> planets = new ArrayList<>();
    static List<Edge> edges = new ArrayList<>();
    static int[] parents;

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parents = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new int[]{i, x, y, z});
            parents[i] = i; //유니온 파인드 초기화
        }

        for (int d = 1; d <= 3; d++) { //x,y,z 순대로
            int finalD = d;
            planets.sort(Comparator.comparing(p -> p[finalD]));
            for (int i = 1; i < N; i++) {
                int from = planets.get(i - 1)[0];
                int to = planets.get(i)[0];
                int cost = Math.abs(planets.get(i - 1)[finalD] - planets.get(i)[finalD]);
                edges.add(new Edge(from, to, cost));
            }
        }
        Collections.sort(edges);
        int totalCost = 0;
        int edgeCount = 0;
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                totalCost += edge.cost;
                edgeCount++;
                if (edgeCount == N - 1) {
                    break;
                }
            }
        }
        System.out.println(totalCost);
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parents[rootB] = rootA;
        }
    }
}
