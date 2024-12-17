import java.util.HashSet;

public class Main {

    static HashSet<Long> hs = new HashSet<>();

    public static void main(String[] args) throws Exception {
        long n = read(), m = read();
        hs.add(1L);
        isPossible(n);
        System.out.println(hs.contains(m) ? "YES" : "NO");
    }

    private static void isPossible(long A) {
        if (hs.contains(A))
            return;
        hs.add(A);
        if (A % 2 == 0)
            isPossible(A / 2);
        else {
            isPossible((A - 1) / 2);
            isPossible((A - 1) / 2 + 1);
        }
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}