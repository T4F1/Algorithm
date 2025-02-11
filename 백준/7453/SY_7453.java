import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];
		long[] B = new long[N];
		long[] C = new long[N];
		long[] D = new long[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
			C[i] = Long.parseLong(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
		}

		long[] AB = new long[N * N];
		long[] CD = new long[N * N];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx] = C[i] + D[j];
				idx++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		long cnt = 0;
		int l = 0, r = N * N - 1;
		while (0 <= r && l < N * N) {
			if (CD[r] + AB[l] < 0) {
				l++;
			} else if (CD[r] + AB[l] > 0) {
				r--;
			} else {
				int lc = 1, rc = 1;
				while (l < N * N - 1 && AB[l] == AB[l + 1]) {
					l++;
					lc++;
				}
				while (0 < r && CD[r] == CD[r - 1]) {
					r--;
					rc++;
				}
				cnt += (long) lc * rc;
				l++;
			}
		}

		System.out.println(cnt);
	}
}
