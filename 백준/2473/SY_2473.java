import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] lq = new long[N];
		for (int i = 0; i < N; i++)
			lq[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(lq);

		// N(logN)
		long[] ans = new long[3];
		long total = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int l = i + 1, r = N - 1;
			while (i < l && i < r && l < r) {
				long input = Math.abs(lq[i] + lq[l] + lq[r]);
				if (total > input) {
					total = input;
					ans[0] = lq[i];
					ans[1] = lq[l];
					ans[2] = lq[r];
				}

				if (lq[l] + lq[r] + lq[i] > 0)
					r--;
				else if (lq[l] + lq[r] + lq[i] < 0)
					l++;
				else
					break;

			}
		}

		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}
