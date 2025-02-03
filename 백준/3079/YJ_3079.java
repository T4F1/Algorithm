import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[] time = new long[n];
		for (int i = 0; i < n; i++) {
			time[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(time);
		long l = 0, r = time[n - 1] * m, answer = 0L;
		while (l <= r) {
			long mid = ((long) (l + r) / 2L);
			long sum = 0L;
			for (int i = 0; i < n; i++) {
				if (sum > m)
					break;
				sum += (long) mid / time[i];
			}
			if (sum >= m) {
				answer = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
