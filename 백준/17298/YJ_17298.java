import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		int[] result = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!dq.isEmpty() && dq.peek() <= num[i]) {
				dq.pop();
			}
			result[i] = dq.isEmpty() ? -1 : dq.peek();
			dq.push(num[i]);
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
