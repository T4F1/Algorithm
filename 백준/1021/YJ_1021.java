import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			dq.offer(i);
		}
		int[] num = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		for (int i = 0; i < m; i++) {
			int cnt = 0;
			while (dq.peek() != num[i]) {
				dq.offer(dq.poll());
				cnt++;
			}
			total += Math.min(cnt, dq.size() - cnt);
			dq.poll();
		}
		System.out.println(total);
	}
}
