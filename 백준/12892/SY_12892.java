import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		Gift[] gift = new Gift[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gift[i] = new Gift(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}

		Arrays.sort(gift, (o1, o2) -> Long.compare(o1.P, o2.P));

		int s = 0;
		long sum = 0, max = Integer.MIN_VALUE;
		for (int e = 0; e < N; e++) {
			sum += gift[e].V;
			while (gift[e].P - gift[s].P >= D) {
				sum -= gift[s].V;
				s++;
			}
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}

	public static class Gift {

		public long P;
		public long V;

		public Gift(long P, long V) {
			this.P = P;
			this.V = V;
		}
	}
}
