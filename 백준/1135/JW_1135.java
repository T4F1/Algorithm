import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int n;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        n = read();
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
            int parent = read();
            if (parent == -1)
                continue;
            tree.get(parent).add(i);
        }
        recursive(0);
        System.out.println(dp[0]);
    }

    private static void recursive(int cur) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int next : tree.get(cur)) {
            recursive(next);
            al.add(dp[next]);
        }
        al.sort(Collections.reverseOrder());
        for (int i = 0; i < al.size(); i++)
            dp[cur] = Math.max(dp[cur], al.get(i) + i + 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}
