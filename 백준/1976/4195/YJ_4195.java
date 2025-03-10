import java.util.*;
import java.io.*;

public class Main {
	
	static Map<String, String> map;
	static Map<String, Integer> network;
	
	static void union(String n1, String n2) {
		String s1 = find(n1);
		String s2 = find(n2);
		
		if (s1.compareTo(s2) < 0) {
			map.put(s1, s2);
			network.put(s2, network.get(s1) + network.get(s2));
		} else if (s1.compareTo(s2) > 0) {
			map.put(s2, s1);
			network.put(s1, network.get(s1) + network.get(s2));
		}
	}
	
	static String find(String n) {
		if (map.get(n) == n) return n;
		return find(map.get(n));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			network = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String n1 = st.nextToken();
				String n2 = st.nextToken();
				map.putIfAbsent(n1, n1);
				map.putIfAbsent(n2, n2);
				network.putIfAbsent(n1, 1);
				network.putIfAbsent(n2, 1);
				union(n1, n2);
				sb.append(network.get(find(n1))).append("\n");	
			}
		}
		System.out.println(sb);
	}
}
