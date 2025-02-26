import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] tree = new int[10_001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int n = 0;
        while (!(str = br.readLine()).equals(""))
            tree[n++] = Integer.parseInt(str);
        postOrder(0, n);
        System.out.println(sb);
    }

    private static void postOrder(int s, int e) {
        if (s >= e)
            return;
        int m = findSplit(s, e, tree[s]);
        postOrder(s + 1, m);
        postOrder(m, e);
        sb.append(tree[s]).append("\n");
    }

    private static int findSplit(int l, int r, int target) {
        int m = l + 1;
        while (m < r && tree[m] < target) {
            m++;
        }
        return m;
    }
}
