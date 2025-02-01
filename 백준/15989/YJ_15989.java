import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());	
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			int[] dp = new int[num + 1];
			dp[0] = 1;
			for (int i = 1; i <= 3; i++) {
				for (int j = i; j <= num; j++) {
					dp[j] += dp[j - i];
				}
			}
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb);
	}
}
