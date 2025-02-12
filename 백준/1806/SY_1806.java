import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());

		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());

		long[] dp = new long[N];
		dp[0] = arr[0];
		for (int i = 1; i < N; i++)
			dp[i] = dp[i - 1] + arr[i];

		int s = 0, e = 0;
		int min = Integer.MAX_VALUE;
		while (s <= e && e <= N - 1) {
			if (dp[e] - dp[s] + arr[s] < S)
				e++;
			else {
				min = Math.min(min, e - s + 1);
				s++;
			}
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
