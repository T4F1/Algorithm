import java.util.*;
import java.io.*;

public class ES_30408 {
    static long m;
    static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);

        divide(n);
        System.out.println(set.contains(m) ? "YES" : "NO");
    }

    private static void divide(long n) {
        if (set.contains(n)) {
            return;
        }
        set.add(n);

        if (n % 2 == 0) {
            divide(n / 2);
        } else {
            divide((n - 1) / 2);
            divide((n - 1) / 2 + 1);
        }
    }
}
