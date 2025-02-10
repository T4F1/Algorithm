import java.util.Arrays;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int total = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if (r == i) {
                    r--;
                    continue;
                }
                if (l == i) {
                    l++;
                    continue;
                }
                if (arr[l] + arr[r] == arr[i]) {
                    total++;
                    break;
                }
                if (arr[l] + arr[r] > arr[i])
                    r--;
                else
                    l++;
            }
        }
        System.out.println(total);
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
