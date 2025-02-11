public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), d = read(), k = read(), c = read();
        int[] dishes = new int[n * 2];
        for (int i = 0; i < n; i++)
            dishes[i] = dishes[i + n] = read();
        int[] types = new int[d + 1];
        int used = 0;
        for (int i = 0; i < k; i++) {
            int dish = dishes[i];
            if (types[dish] == 0)
                used++;
            types[dish]++;
        }
        int max = types[c] == 0 ? used + 1 : used;
        for (int i = 0; i < 2 * n - k; i++) {
            int l = dishes[i], r = dishes[i + k];
            types[l]--;
            if (types[l] == 0)
                used--;
            if (types[r] == 0)
                used++;
            types[r]++;
            max = Math.max(max, types[c] == 0 ? used + 1 : used);
        }
        System.out.println(max);
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
