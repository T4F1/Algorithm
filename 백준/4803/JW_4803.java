import java.util.HashSet;

public class Main {

    static int n, m;
    static int[] parent;
    static boolean[] isCycle;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true) {
            n = read();
            m = read();
            if (n == 0 && m == 0)
                break;
            parent = new int[n + 1];
            isCycle = new boolean[n + 1];
            for (int i = 0; i < n + 1; i++)
                parent[i] = i;
            for (int i = 0; i < m; i++) {
                int u = read(), v = read();
                int rootU = find(u), rootV = find(v);
                if (rootU == rootV)
                    isCycle[rootU] = true;
                parent[rootU] = rootV;
                isCycle[rootV] |= isCycle[rootU];
            }
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i < n + 1; i++) {
                int root = find(i);
                if (!isCycle[root])
                    hs.add(root);
            }
            sb.append("Case ").append(++idx).append(": ");
            if (hs.size() == 0)
                sb.append("No trees.\n");
            else if (hs.size() == 1)
                sb.append("There is one tree.\n");
            else
                sb.append("A forest of ").append(hs.size()).append(" trees.\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parent[x] == x)
            return parent[x];
        return parent[x] = find(parent[x]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}