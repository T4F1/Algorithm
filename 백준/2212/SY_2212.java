import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[] coordinate = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			coordinate[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coordinate); // NlogN
		
		int[] dp = new int[N-1];
		for(int i = 1; i < N; i++) {
			dp[i - 1] = coordinate[i] - coordinate[i - 1];
		}
		
		Arrays.sort(dp); // NlogN
		
		int result = 0;
		for(int i = 0; i < N-k ;i++) {
			result += dp[i];
		}
		
		System.out.println(result);
		
		br.close();
	}
}
