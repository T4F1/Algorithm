import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] children = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			children[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(children);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			list.add(children[i + 1] - children[i]);
		}
		Collections.sort(list);
		int cost = 0;
		for (int i = 0; i < n - k; i++) {
			cost += list.get(i);
		}
		System.out.println(cost);
	}
}
