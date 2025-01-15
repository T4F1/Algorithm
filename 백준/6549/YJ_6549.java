import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			long[] num = new long[n + 1];
			for (int i = 0; i < n; i++) {
				num[i] = Long.parseLong(st.nextToken());
			}
			num[n] = 0;
			long maxSquare = 0;
			Deque<Integer> dq = new ArrayDeque<>();
			for (int i = 0; i <= n; i++) {
				while (!dq.isEmpty() && num[dq.peek()] > num[i]) {
					long height = num[dq.pop()];
					long width = dq.isEmpty() ? i : i - dq.peek() - 1;
					maxSquare = Math.max(maxSquare, height * width);
				}
				dq.push(i);
			}
			sb.append(maxSquare).append("\n");
		}
		System.out.println(sb);
	}
}
