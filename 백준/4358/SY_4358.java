import java.util.*;
import java.io.*;

public class Main {

	private static final TreeMap<String, Integer> trees = new TreeMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String tree = "";
		int cnt = 0;
		while(true) {
			tree = br.readLine();
			if(tree == null) break;
			trees.put(tree, trees.getOrDefault(tree, 0) + 1);
			cnt++;
		}
		
		for(String t: trees.keySet()) {
			int value = trees.get(t);
			double result = (double)value/cnt*100;
			System.out.printf("%s %.4f\n", t, result);
		}
		
		br.close();
	}
	
}
