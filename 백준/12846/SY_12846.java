import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		long maxMoney = 0;
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && T[stack.peek()] >= T[i]) {
				int money = T[stack.peek()];
				stack.pop();
				long workDay = stack.isEmpty() ? i : i - 1 - stack.peek();
				maxMoney = Math.max(maxMoney, workDay * money);
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int money = T[stack.peek()];
			stack.pop();
			long workDay = stack.isEmpty() ? n : n - 1 - stack.peek();
			maxMoney = Math.max(maxMoney, workDay * money);
		}
		
		System.out.println(maxMoney);
		
	}
}
