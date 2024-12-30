public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), r = read(), c = read();
        System.out.println(recursive(n, 0, 0, r, c));
    }

    private static int recursive(int n, int sr, int sc, int r, int c) {
        int cnt = 0;
        int subLen = (int) Math.pow(2, n - 1);
        int type = calType(subLen, sr, sc, r, c);
        cnt += subLen * subLen * type;
        if (n == 1)
            return cnt;
        if (type == 0) {
            return cnt + recursive(n - 1, sr, sc, r, c);
        } else if (type == 1) {
            return cnt + recursive(n - 1, sr, sc + subLen, r, c);
        } else if (type == 2) {
            return cnt + recursive(n - 1, sr + subLen, sc, r, c);
        }
        return cnt + recursive(n - 1, sr + subLen, sc + subLen, r, c);
    }

    private static int calType(int subLen, int sr, int sc, int r, int c) {
        if (r < sr + subLen) {
            if (c < sc + subLen)
                return 0;
            return 1;
        } else if (c < sc + subLen)
            return 2;
        return 3;
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