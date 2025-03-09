import java.util.HashSet;

public class Main {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            parent[i] = i;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (read() == 1)
                    union(i, j);
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < m; i++)
            hs.add(find(read()));
        System.out.println(hs.size() == 1 ? "YES" : "NO");
    }

    private static int find(int x) {
        if (parent[x] == x)
            return parent[x];
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        parent[rootX] = rootY;
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