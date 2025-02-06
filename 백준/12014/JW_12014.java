import java.util.Arrays;

public class Main {

    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        for (int tt = 1; tt <= t; tt++) {
            n = read();
            k = read();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = read();
            sb.append("Case #").append(tt).append("\n");
            sb.append(isPossible() ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible() {
        int[] lis = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(lis, 0, len, arr[i]);
            if (pos < 0)
                pos = ~pos;
            lis[pos] = arr[i];
            if (pos == len)
                len++;
            if (len >= k)
                return true;
        }
        return false;
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
