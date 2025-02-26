import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}

	static List<List<Integer>> tree = new ArrayList<>();
	
	public static int dfs(int node) {
		if (tree.get(node).isEmpty()) return 0;
		
		List<Integer> times = new ArrayList<>();
		for (int child : tree.get(node)) {
			times.add(dfs(child));
		}
		Collections.sort(times, Collections.reverseOrder());
		int time = 0;
		for (int i = 0; i < times.size(); i++) {
			time = Math.max(time, times.get(i) + i + 1);
		}
		return time;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			int parent = read();
			if (parent == -1) continue;
			tree.get(parent).add(i);
		}
		System.out.println(dfs(0));
	}
}
1135/
