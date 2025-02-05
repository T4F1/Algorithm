import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			sb.append("Case #").append(test).append("\n");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] stock = new int[N];
			int[] LIS = new int[N];
			st = new StringTokenizer(br.readLine());

			int idx = 0;
			for (int i = 0; i < N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());

				int start = 0, end = idx - 1;
				while (start <= end) {
					int mid = (start + end) / 2;
					if (stock[i] <= LIS[mid]) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}

				LIS[start] = stock[i];
				if (start == idx)
					idx++;
			}

			if (idx >= K)
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");

		}

		System.out.println(sb);
	}

}
