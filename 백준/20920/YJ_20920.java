import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeMap<String, Integer> tm = new TreeMap<>((o1, o2) -> {
			if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같으면 사전순
            } return Integer.compare(o1.length(), o2.length());
		});
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			if (word.length() >= m) {
				tm.put(word, tm.getOrDefault(word, 0) + 1);
			}
		}
		List<String> list = new ArrayList<>(tm.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (tm.get(o1) != tm.get(o2)) {
					return tm.get(o2) - tm.get(o1);
				} else if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				} return o1.compareTo(o2);
		}});
		for (String s : list) {
			sb.append(s);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
