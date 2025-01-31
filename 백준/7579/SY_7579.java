import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] memory = new int[N];
		int[] cost = new int[N];
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int totalCost = 0;
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken()); //메모리가 무게
			cost[i] = Integer.parseInt(st2.nextToken()); // 비용이 가치
			totalCost += cost[i];
		}

		int[] dp = new int[totalCost + 1];

		for (int i = 0; i < N; i++) { 
			for (int j = totalCost; j >= cost[i]; j--) { 
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
			}
		}
		
		for(int i = 0; i <= totalCost; i++) {
			if(dp[i] >= K) {
				System.out.println(i);
				break;
			}
		}
	}
}
