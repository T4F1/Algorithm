import java.io.*;
import java.util.*;

public class ES_2887 {
    static Point[] pos;
    static List<Edge> edges;
    static int[] parents;

    public static void main(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        pos = new Point[n];

        for(int i=0; i<n; i++){
            int[] input = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            pos[i] = new Point(i, input[0], input[1], input[2]);
        }

        edges = new ArrayList<>();

        Arrays.sort(pos, Comparator.comparingInt(o -> o.x));
        for(int i=0; i<n-1; i++){
            Point p1 = pos[i];
            Point p2 = pos[i+1];
            long distance = Math.abs(p1.x - p2.x);
            edges.add(new Edge(p1.val, p2.val, distance));
            edges.add(new Edge(p2.val, p1.val, distance));
        }

        Arrays.sort(pos, Comparator.comparingInt(o -> o.y));
        for(int i=0; i<n-1; i++){
            Point p1 = pos[i];
            Point p2 = pos[i+1];
            long distance = Math.abs(p1.y - p2.y);
            edges.add(new Edge(p1.val, p2.val, distance));
            edges.add(new Edge(p2.val, p1.val, distance));
        }

        Arrays.sort(pos, Comparator.comparingInt(o -> o.z));
        for(int i=0; i<n-1; i++){
            Point p1 = pos[i];
            Point p2 = pos[i+1];
            long distance = Math.abs(p1.z - p2.z);
            edges.add(new Edge(p1.val, p2.val, distance));
            edges.add(new Edge(p2.val, p1.val, distance));
        }

        parents = new int[n];
        for(int i=0; i<n; i++)
            parents[i] = i;

        System.out.println(kruskal(n));
    }

    private static long kruskal(int n) {
        Collections.sort(edges);
        long answer = 0;
        int pick = 0;
        for (Edge e : edges) {
            int start = find(e.start);
            int end = find(e.end);
            if (start != end) {
                parents[end] = start;
                answer += e.distance;
                pick++;
            }
            if (pick == n - 1)
                break;
        }
        return answer;
    }

    static int find(int x){
        if(parents[x] == x) return parents[x];
        return parents[x] = find(parents[x]);
    }

    static class Edge implements Comparable<Edge>{
        int start, end;
        long distance;

        public Edge(int start, int end, long distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o){
            return Long.compare(this.distance, o.distance);
        }
    }

    static class Point{
        int val,x,y,z;

        Point(int val, int x, int y, int z){
            this.val = val;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
