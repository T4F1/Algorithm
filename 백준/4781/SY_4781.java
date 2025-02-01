import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
			if (N == 0 && M == 0)
				break;

			int[] cal = new int[N + 1];
			int[] price = new int[N + 1];
			int[] dp = new int[M + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				cal[i] = Integer.parseInt(st.nextToken());
				price[i] = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
			}

			for (int i = 1; i <= N; i++) {
				for(int j = price[i]; j <= M; j++) {
					dp[j] = Math.max(dp[j], dp[j-price[i]] + cal[i]);
				}
			} 

			sb.append(dp[M]).append("\n");
		}

		System.out.println(sb);
	}
}
