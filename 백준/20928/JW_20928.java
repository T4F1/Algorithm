public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = read();
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = read();
		int now = p[0] + x[0], idx = 0, cnt = 0;
		while (now < m) {
			int next = now;
			while (++idx < n && p[idx] <= now) 
				next = Math.max(next, p[idx] + x[idx]);
			if (next == now) {
				System.out.println(-1);
				return;
			}
			now = next;
			cnt++;
		}
		System.out.println(cnt);
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
