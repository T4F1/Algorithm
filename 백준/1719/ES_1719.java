import java.io.*;
import java.util.*;

public class ES_1719 {
    static List<List<Node>> graph = new ArrayList<>();
    static int[][] path;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        path = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            for(int j=1; j<=n; j++) path[i][j] = j;
        }

        for(int i=0; i<m ;i++){
            st = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(v).add(new Node(w, time));
            graph.get(w).add(new Node(v, time));
        }

        for(int i=1; i<=n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);
        }

        StringBuilder answer = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                answer.append(i==j ? "-" : path[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.weight));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;

            for (Node node : graph.get(now)) {
                int next = node.v;
                int nextWeight = node.weight;

                if (dist[now] + nextWeight < dist[next]) {
                    dist[next] = dist[now] + nextWeight;

                    if (now == start)
                        path[start][next] = next;  // 바로 가는 경우
                    else
                        path[start][next] = path[start][now];  // 첫 이동을 저장

                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
    }

    static class Node{
        int v, weight;

        Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
    }
}
