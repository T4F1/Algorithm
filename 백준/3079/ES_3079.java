import java.io.*;
import java.util.*;

public class ES_3079 {
    static int[] arr;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        long l = 1;
        long r = (long) arr[n - 1] * m;
        while (l < r) {
            long mid = (l + r) / 2;
            if (calcSum(mid) >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

    private static long calcSum(long mid) {
        long sum = 0;
        for (int idx : arr) {
            sum += mid / idx;
            if (sum >= m) break;
        }
        return sum;
    }
}