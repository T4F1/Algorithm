import java.util.*;
import java.io.*;

public class BOJ2 {

	static long MOD = 10_007;
	static long[][] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		array = new long[n + 1][k + 1];

		System.out.println(mod(n, k));
	}

	public static long mod(int n, int k) {
		if (array[n][k] != 0)
			return array[n][k];
		if (n == k || k == 0) {
			return array[n][k] = 1;
		} else {
			array[n][k] = (mod(n - 1, k - 1) + mod(n - 1, k)) % MOD;
		}
		return array[n][k];
	}
}
