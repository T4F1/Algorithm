import java.io.*;
import java.util.*;

public class Main {

	private static final int REMOVE_MIN = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			TreeMap<Integer, Integer> tree = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			for(int j = 0; j < k; j++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if(order.equals("I")) {
					tree.put(number, tree.getOrDefault(number, 0)+1);
				} else if(order.equals("D")) {
					if(tree.isEmpty()) {
						continue;
					}
					
					int key;
					if(number == REMOVE_MIN) {
						key = tree.firstKey();
					} else {
						key = tree.lastKey();
					}
					
					if(tree.get(key) > 1) {
						tree.put(key, tree.get(key) - 1);
					} else if(tree.get(key) == 1) {
						tree.remove(key);
					}
				}
			}
			
			if(tree.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tree.lastKey() + " " + tree.firstKey() + "\n");
			}	
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
