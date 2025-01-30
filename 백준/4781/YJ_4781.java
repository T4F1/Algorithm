import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = (int) (Float.parseFloat(st.nextToken()) * 100.0 + 0.5);
			if (n == 0 && m == 0)
				break;
			int[] calorie = new int[n + 1];
			int[] price = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				calorie[i] = Integer.parseInt(st.nextToken());
				price[i] = (int) (Float.parseFloat(st.nextToken()) * 100.0 + 0.5);
			}
			int maxCalorie = 0;
			int[] dp = new int[m + 1];
			for (int i = 1; i <= n; i++) {
			    for (int j = price[i]; j <= m; j++) {
			        dp[j] = Math.max(dp[j], dp[j - price[i]] + calorie[i]);
			    }
			}
			maxCalorie = dp[m];
			sb.append(maxCalorie).append("\n");
		}
		System.out.println(sb);
	}
}
