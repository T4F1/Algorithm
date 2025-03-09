import java.io.*;
import java.util.*;

public class ES_2463 {
    static int n, m;
    static int[] parent;
    static int[] child;
    static List<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long sum = 0;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            sum += w;
            list.add(new Edge(Math.min(x, y), Math.max(x, y), w));
        }
        parent = new int[n+1];
        child = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
            child[i] = 1;
        }

        long answer = 0;
        Collections.sort(list);

        for(Edge edge:list){
            answer += sum * union(edge.x, edge.y);
            answer %= 1_000_000_000;
            sum -= edge.cost;
        }

        System.out.println(answer);
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static long union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return 0;
        parent[y] = x;
        long cnt = (long) child[x] * child[y];
        child[x] += child[y];
        child[y] = 0;
        return cnt;
    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int cost;
        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return o.cost - this.cost;
        }
    }
}