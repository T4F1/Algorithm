import java.util.*;
import java.io.*;

public class BOJ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean isNotPrime[] = new boolean[n + 1];
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (!isNotPrime[i]) {
				primes.add(i);
				for (int j = i + i; j <= n; j = j + i) {
					isNotPrime[j] = true;
				}
			}
		}
		long lcm = 1;
		for (int prime : primes) {
			long power = prime;
			while (power * prime <= n) {
				power *= prime;
			}
			lcm = (lcm * (power % (long) Math.pow(2, 32)) % (long) Math.pow(2, 32));
		}
		System.out.println(lcm);
	}

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
