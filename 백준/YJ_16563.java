import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MAX = 5_000_000;
		boolean[] isNotPrime = new boolean[MAX + 1];
		List<Integer> primes = new ArrayList<>();
		int root = (int)Math.sqrt((double)MAX);
		
		// 소수 판별
		for (int i = 2; i <= MAX; i++) {
			if (!isNotPrime[i]) {
				primes.add(i);
				for (int j = i + i; j <= MAX; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		while (n-- > 0) {
			int k = Integer.parseInt(st.nextToken());
			for (int prime : primes) {
				if (prime * prime > k) break;
				while (k % prime == 0) {
					bw.write(prime + " ");
                    k /= prime;
                }
			}
			if (k > 1) bw.write(k + " ");
			bw.write("\n");
		}
		bw.flush(); // 남아있는 데이터를 출력
		bw.close(); // 스트림 닫기
	}
}
