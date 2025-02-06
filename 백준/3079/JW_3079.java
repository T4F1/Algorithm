public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n];
        long maxTime = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            maxTime = Math.max(maxTime, arr[i]);
        }
        long l = 1, r = maxTime * m;
        while (l <= r) {
            long m = (l + r) / 2;
            if (isPossible(m))
                r = m - 1;
            else
                l = m + 1;
        }
        System.out.println(l);
    }

    private static boolean isPossible(long target) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += target / arr[i];
            if (cnt >= m)
                return true;
        }
        return cnt >= m;
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
