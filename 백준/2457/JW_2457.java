import java.util.Arrays;

public class Main {

	static final int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] flowers = new int[n][2];
		for (int i = 0; i < n; i++) {
			int sm = read(), sd = read(), em = read(), ed = read();
			flowers[i] = new int[] { convert(sm, sd), convert(em, ed) };
		}
		Arrays.sort(flowers, (o1, o2) -> o1[0] - o2[0]);
		int s = convert(3, 1), e = convert(12, 1);
		int now = s, idx = 0, cnt = 0;
		while (now < e) {
			int next = now;
			while (idx < n && flowers[idx][0] <= now) {
				next = Math.max(next, flowers[idx][1]);
				idx++;
			}
			if (next == now) {
				System.out.println(0);
				return;
			}
			now = next;
			cnt++;
		}
		System.out.println(cnt);
	}

	private static int convert(int month, int day) {
		int result = 0;
		for (int i = 1; i < month; i++)
			result += days[i];
		result += day;
		return result;
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
