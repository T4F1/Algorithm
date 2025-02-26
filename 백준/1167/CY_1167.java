import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름 {
    static int V = 0;
    static boolean[] visited;
    static List<Node>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            input:
            while (true) {
                for (int j = 0; j < 2; j++) {
                    int near = Integer.parseInt(st.nextToken());
                    if (near == -1) {
                        break input;
                    }
                    int distance = Integer.parseInt(st.nextToken());
                    graph[target].add(new Node(near, distance));
                    graph[near].add(new Node(target, distance)); //양방향 저장
                }
            }
        }
        int[] farthestNode = dfs(1);
        System.out.println(dfs(farthestNode[0])[1]);
    }

    private static int[] dfs(int start) {
        visited = new boolean[V + 1];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{start, 0}); //1번 노드에서 시작, 초기 누적 거리 0
        visited[start] = true;
        int farNode = start;
        int max = 0;

        while (!dq.isEmpty()) {
            int[] nodes = dq.poll();
            int current = nodes[0];
            int dis = nodes[1];

            for (Node node : graph[current]) {
                if (max < dis) {
                    max = dis;
                    farNode = current;
                }
                if (!visited[node.point]) {
                    visited[node.point] = true;
                    dq.add(new int[]{node.point, dis + node.distance});
                }
            }
        }
        return new int[]{farNode, max};
    }

    public static class Node {
        int point;
        int distance;

        public Node(int point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}
