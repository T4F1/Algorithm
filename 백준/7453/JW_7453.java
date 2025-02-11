import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] A = new int[n], B = new int[n], C = new int[n], D = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = read();
            B[i] = read();
            C[i] = read();
            D[i] = read();
        }
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        Arrays.sort(AB);
        Arrays.sort(CD);
        int l = 0, r = n * n - 1;
        long cnt = 0;
        while (0 <= r && l < n * n) {
            if (AB[l] + CD[r] < 0)
                l++;
            else if (AB[l] + CD[r] > 0)
                r--;
            else {
                int lc = 1, rc = 1;
                while (l < n * n - 1 && AB[l] == AB[l + 1]) {
                    l++;
                    lc++;
                }
                while (0 < r && CD[r] == CD[r - 1]) {
                    r--;
                    rc++;
                }
                cnt += (long) lc * rc;
                l++;
            }
        }
        System.out.println(cnt);
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
