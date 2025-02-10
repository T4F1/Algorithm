public class Main {

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        s = read();
        arr = new int[n + 1];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int l = 0, r = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < n + 1) {
            if (sum < s) {
                sum += arr[r++];
            } else {
                minLen = Math.min(minLen, r - l);
                sum -= arr[l++];
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
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
