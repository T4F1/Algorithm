import java.io.*;
import java.util.*;

public class ES_1976 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i + 1, j);
                }
            }
        }

        int[] dest = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i=1; i<dest.length; i++) {
            if (find(dest[0]) != find(dest[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
