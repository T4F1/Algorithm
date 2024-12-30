public class Main {

    static int max = 0, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int n = read();
        recursive(n, 0);
        System.out.println(min + " " + max);
    }

    private static void recursive(int n, int cnt) {
        int len = (int) Math.log10(n) + 1;
        cnt += getOddCnt(n);
        if (len == 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        } else if (len == 2) {
            recursive(n / 10 + n % 10, cnt);
        } else {
            for (int i = 0; i < len - 2; i++) {
                int temp = n;
                int div = (int) Math.pow(10, len - i - 1);
                int a = temp / div;
                temp %= div;
                for (int j = i + 1; j < len - 1; j++) {
                    div = (int) Math.pow(10, len - j - 1);
                    int b = temp / div;
                    int c = temp % div;
                    recursive(a + b + c, cnt);
                }
            }
        }
    }

    private static int getOddCnt(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n % 10) % 2 == 1)
                cnt++;
            n /= 10;
        }
        return cnt;
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