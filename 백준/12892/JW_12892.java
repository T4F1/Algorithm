import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), d = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read() };
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int l = 0, r = 0;
        long max = 0, sum = 0;
        while (l <= r && r < n) {
            if (arr[r][0] - arr[l][0] >= d) {
                sum -= arr[l][1];
                l++;
            } else {
                sum += arr[r][1];
                max = Math.max(max, sum);
                r++;
            }
        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
