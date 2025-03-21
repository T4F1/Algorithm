import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CY_2211 {
    static int N, M, cnt = 0;
    static List<Edge>[] graph;
    static int[] connect;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        M = Integer.parseInt(st.nextToken()); // 회선 개수

        graph = new ArrayList[N + 1];
        connect = new int[N + 1]; // 최소 경로 연결 정보
        dist = new int[N + 1]; // 최소 거리 저장

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }

        // 다익스트라 실행
        dijkstra();

        for (int i = 1; i <= N; i++) {
            if (connect[i] != 0) {
                cnt++;
                sb.append(i).append(" ").append(connect[i]).append("\n");
            }
        }

        System.out.println(cnt);
        System.out.print(sb);
    }

    private static void dijkstra() {
        Arrays.fill(dist, (int) 1e9);
        dist[1] = 0; // 시작 노드는 거리 0

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll(); // 현재 최소 거리 노드

            if (dist[curr.to] < curr.cost) {
                continue;
            }

            for (Edge next : graph[curr.to]) { // 인접한 노드 확인
                int newDist = dist[curr.to] + next.cost; // 현재까지의 거리 + 인접 노드 거리
                if (newDist < dist[next.to]) { //현재까지 저장된 dist[next.to] 값보다 newDist가 더 작다면,
                    dist[next.to] = newDist; // newDist로 갱신합니다.
                    pq.add(new Edge(next.to, newDist));
                    connect[next.to] = curr.to; // 연결 정보 저장
                }
            }
        }
    }
}
