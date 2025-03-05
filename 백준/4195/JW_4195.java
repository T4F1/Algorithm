import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, Integer> hm;
    static ArrayList<Integer> parent, child;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine()), idx = 0;
            hm = new HashMap<>();
            parent = new ArrayList<>();
            child = new ArrayList<>();
            String A, B;
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                A = st.nextToken();
                B = st.nextToken();
                if (!hm.containsKey(A)) {
                    hm.put(A, idx);
                    parent.add(idx++);
                    child.add(1);
                }
                if (!hm.containsKey(B)) {
                    hm.put(B, idx);
                    parent.add(idx++);
                    child.add(1);
                }
                union(hm.get(A), hm.get(B));
                sb.append(child.get(find(hm.get(A)))).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parent.get(x) != x) {
            int root = find(parent.get(x));
            parent.set(x, root);
        }
        return parent.get(x);
    }

    private static void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY)
            return;
        parent.set(rootY, rootX);
        child.set(rootX, child.get(rootX) + child.get(rootY));
    }
}
