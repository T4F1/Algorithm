import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        long sum, min = Long.MAX_VALUE;
        int[] answer = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                sum = (long) arr[i] + arr[l] + arr[r];
                long abs = Math.abs(sum);
                if (min > abs) {
                    answer = new int[] { arr[i], arr[l], arr[r] };
                    min = abs;
                }
                if (sum > 0)
                    r--;
                else
                    l++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer)
            sb.append(i).append(" ");
        System.out.println(sb);
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