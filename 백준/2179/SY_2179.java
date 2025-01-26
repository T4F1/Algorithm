import java.util.*;
import java.io.*;

public class Main {

	private static final Map<String, TreeMap<Integer, String>> words = new LinkedHashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(words.containsKey(word)) continue;
			
			TreeMap<Integer, String> prefix = new TreeMap<>((o1, o2) -> o2 - o1);
			for(String w: words.keySet()) {
				int len = calculatePrefixLength(word, w);
				if(prefix.containsKey(len)) {
					continue;
				}
				prefix.put(len, w);
			}
			
			words.put(word, prefix);
		}
		
		int max = -1;
		String S = "", T = "";
		for(String word: words.keySet()) {
			TreeMap<Integer, String> prefix = words.get(word);
			if(prefix.isEmpty()) continue;
			
			if(max < prefix.firstKey()) {
				max = prefix.firstKey();
				S = prefix.get(max);
				T = word;
			} else if(max == prefix.firstKey()) {
				int len = prefix.firstKey();
				for(String w: words.keySet()) {
					if(w.equals(S)) {
						break;
					} else if(w.equals(prefix.get(len))) {
						S = prefix.get(len);
						T = word;
					}
				}
			}
		}
		
		System.out.println(S + "\n" + T);
		
		br.close();
	}
	
	private static int calculatePrefixLength(String A, String B) {
		int len = A.length() > B.length() ? B.length() : A.length();
		int rst = 0;
		for(int i = 0; i < len; i++) {
			if(A.charAt(i) != B.charAt(i)) break;
			rst++;
		}
		return rst;
	}
}
