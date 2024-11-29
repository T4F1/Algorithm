import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String f = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (f.equals("I")) {
					tm.put(num, tm.getOrDefault(num, 0) + 1);
				} else if (f.equals("D")) {
					if (!tm.isEmpty() && num == 1) {
						int removeNum = tm.lastKey();
						if (tm.get(removeNum) == 1) tm.remove(removeNum);
						else tm.put(removeNum, tm.get(removeNum) - 1);
					}
					if (!tm.isEmpty() && num == -1) {
						int removeNum = tm.firstKey();
						if (tm.get(removeNum) == 1) tm.remove(removeNum);
						else tm.put(removeNum, tm.get(removeNum) - 1);
					}
				}
			}
			if (tm.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
			}
		}
		System.out.println(sb);
	}
}
