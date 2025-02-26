import java.io.*;
import java.util.*;

public class ES_1167 {
    static int v, node;
    static int max = 0;
    static List<List<Node>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(in.readLine());
        list = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            int[] input = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int curNode = input[0];
            for (int j = 1; j < input.length - 1; j += 2) {
                list.get(curNode).add(new Node(input[j], input[j + 1]));
            }
        }

        // 1에서 가장 먼 정점 구하기
        visited = new boolean[v + 1];
        visited[1] = true;
        dfs(1, 0);

        // 현재 노드에서 가장 먼 정점 구하기
        Arrays.fill(visited, false);
        visited[node] = true;
        max = 0;
        dfs(node, 0);

        System.out.println(max);
    }

    private static void dfs(int current, int dis) {
        if (dis > max) {
            max = dis;
            node = current;
        }

        for (Node n : list.get(current)) {
            if (!visited[n.next]) {
                visited[n.next] = true;
                dfs(n.next, dis + n.cost);
            }
        }
    }

    static class Node {
        int next, cost;
        Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}