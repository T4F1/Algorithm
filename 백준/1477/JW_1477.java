import java.util.Arrays;

public class Main {

    static int n, m, l;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        l = read();
        arr = new int[n + 2];
        for (int i = 1; i < n + 1; i++)
            arr[i] = read();
        arr[n + 1] = l;
        Arrays.sort(arr);
        int left = 1, right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }

    private static boolean isPossible(int target) {
        int cnt = 0;
        for (int i = 0; i < n + 1; i++)
            cnt += (arr[i + 1] - arr[i] - 1) / target;
        return cnt > m;
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
