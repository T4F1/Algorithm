import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[500001];
		List<Integer> primes = new ArrayList<>();

		for(int i = 2; i <= 500000; i++) {
			if(arr[i] == -1) continue;
			primes.add(i);
			for(int j = 2; j*i <= 500000; j++) {
				arr[j*i] = -1;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreElements()) {
			int number = Integer.parseInt(st.nextToken());
			for(int prime: primes) {
				if ( prime * prime > number) break;
				while(number % prime == 0) {
					bw.write(prime + " ");
					number /= prime;
				}
			}
			if(number > 1) bw.write(number + " ");
			bw.write("\n");
		}
		br.close();
		bw.close();
	}
}
