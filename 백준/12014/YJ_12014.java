import java.util.*;
import java.io.*;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int tmp = t;
		while (tmp-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] stock = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int idx = Collections.binarySearch(list, stock[i]);
				if (idx < 0) idx = Math.abs(idx) - 1;
				if (list.isEmpty() || list.get(list.size() - 1) < stock[i]) list.add(stock[i]);
				else list.set(idx, stock[i]);
			}
			sb.append("Case #").append(t - tmp).append("\n");
			if (list.size() >= k) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
