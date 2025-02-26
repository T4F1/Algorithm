import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            graph = new ArrayList[n + 1]; //인접리스트
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            int treeCount = 0; //트리개수
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (bfs(i)) {
                        treeCount++;
                    }
                }
            }
            if (treeCount == 0) {
                System.out.printf("Case %d: No trees.\n", test);
            } else if (treeCount == 1) {
                System.out.printf("Case %d: There is one tree.\n", test);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", test, treeCount);
            }
            test++;
        }

    }

    private static boolean bfs(int i) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(i);
        visited[i] = true;

        int nodeCount = 0;
        int edgeCount = 0;

        while (!dq.isEmpty()) {
            int node = dq.poll();
            nodeCount++;

            for (int neighbor : graph[node]) {
                edgeCount++;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dq.offer(neighbor);
                }
            }
        }
        edgeCount /= 2;
        return nodeCount - 1 == edgeCount;
    }
}
