import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] num = new boolean[n + 1];
		int cnt = 0;

		for (int i = 2; i <= n; i++) {
			int j = 1;
			if (!num[i]) {
				while (i * j <= n) {
					if (!num[i * j]) {
						num[i * j] = true;
						cnt++;
					}
					if (cnt == k) {
						System.out.println(i * j);
						return;
					}
					j++;
				}
			}
		}
	}
}
