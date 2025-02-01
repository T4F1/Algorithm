import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[C + 101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); // 비용
            int customer = Integer.parseInt(st.nextToken()); // 유치 고객 수

            for(int j=customer; j< C+101; j++) {
				if (dp[j-customer] != Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], cost+dp[j-customer]);
			}
        }
		
		// 최소 비용 찾기
        int result = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
		
	}
}
