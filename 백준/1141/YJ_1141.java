import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> o2.length() - o1.length());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			pq.offer(str);
		}
		for (int i = 0; i < n; i++) {
			String ns = pq.poll();
			boolean flag = false;
			for (String s : list) {
				if (s.startsWith(ns)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				list.add(ns);
			}
		}
		System.out.println(list.size());
	}
}
