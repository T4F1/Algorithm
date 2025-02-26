import java.io.*;
import java.util.*;

public class ES_4803 {
    static int[] parent;
    static boolean[] hasCycle;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCount = 1;
        while(true) {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            parent = new int[n+1];
            hasCycle = new boolean[n+1];
            for(int i=1; i<=n; i++){
                parent[i] = i;
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(in.readLine());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                union(u,w);
            }

            for(int i=1; i<=n; i++){
                int root = find(i);
                if(hasCycle[i])
                    hasCycle[root] = true;
            }

            int treeCount = 0;
            Set<Integer> roots = new HashSet<>();
            for(int i=1; i<=n; i++){
                int root = find(i);
                if(!hasCycle[root] && !roots.contains(root)){
                    roots.add(root);
                    treeCount++;
                }
            }

            sb.append("Case ").append(testCount).append(": ");
            if(treeCount == 0){
                sb.append("No trees.");
            }
            else if(treeCount == 1){
                sb.append("There is one tree.");
            }
            else{
                sb.append("A forest of ").append(treeCount).append(" trees.");
            }
            sb.append("\n");
            testCount++;
        }
        System.out.println(sb);
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            hasCycle[x] = true;
            return;
        }
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
