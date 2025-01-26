import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		while (num-- > 0) {
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			long sum = 0;
			int n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					sum += gcd(list.get(i), list.get(j));
				}
			}
			System.out.println(sum);
		}
	}

	public static int gcd(int a, int b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}
}
