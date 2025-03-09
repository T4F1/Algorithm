import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2463 {
    static int N, M;
    static long[] size; //집합의 수
    static int[] parents;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static long sum = 0;
    static long result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        size = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i; //부모를 자기 자신으로 초기화
            size[i] = 1; //크기를 1로 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(u, v, w));
            sum += w;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            result += sum * union(cur.u, cur.v);
            result %= 1000000000;
            sum -= cur.w;
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static long union(int a, int b) {
        int la = find(a);
        int lb = find(b);
        if (la == lb) {
            return 0;
        }
        long answer = 0;

        parents[lb] = la; //그룹핑
        answer += ((size[la] * size[lb]));
        size[la] += size[lb];
        size[lb] = 0;
        return answer;
    }

    static class Node implements Comparable<Node> {
        int u, v, w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return o.w - this.w;
        }
    }
}
