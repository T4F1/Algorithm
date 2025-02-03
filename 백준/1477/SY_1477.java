import java.util.*;
import java.io.*;

public class Main {
	static int[] ra;
	static int N, M, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ra = new int[N + 2];
		ra[N + 1] = L;
		ra[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ra[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ra);

		int l = 1, r = L - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (isPossible(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		System.out.println(l);

	}

	public static boolean isPossible(int mid) {
		int sum = 0;
		for (int i = 1; i < ra.length; i++)
			sum += (ra[i] - ra[i - 1] - 1) / mid;
		if (sum > M)
			return true;
		return false;
	}
}
