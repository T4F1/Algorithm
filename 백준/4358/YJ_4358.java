import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Integer> tm = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
		int total = 0;
		String tree;
		while ((tree = br.readLine()) != null) {
			tm.put(tree, tm.getOrDefault(tree, 0) + 1);
			total++;
		}

		for (String treeName : tm.keySet()) {
			double percent = (double) tm.get(treeName) / total * 100;
			sb.append(treeName + " " + String.format("%.4f", percent) + "\n");
		}

		System.out.println(sb);
		br.close();
	}
}
