import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] v = new int[3];
		v[0] = 1;
		v[1] = 2;
		v[2] = 3;

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int K = Integer.parseInt(br.readLine());
			int[] dp = new int[K + 1];
			
			dp[0] = 1;
			for (int i = 0; i < 3; i++) {
				for (int j = v[i]; j <= K; j++) {
					dp[j] += dp[j - v[i]];
				}
			}

			sb.append(dp[K]).append("\n");
			
		}

		System.out.println(sb);

	}
}
