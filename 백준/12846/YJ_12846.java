import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] money = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		money[n] = 0;
		
		int max = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i <= n; i++) {
			while (!dq.isEmpty() && money[dq.peek()] >= money[i]) {
				int wage = money[dq.pop()];
				int day = dq.isEmpty() ? i : i - dq.peek() - 1;
				max = Math.max(max, wage * day);
			}
			dq.push(i);
		}
		System.out.println(max);
	}
}
