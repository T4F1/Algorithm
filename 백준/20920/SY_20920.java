import java.util.*;
import java.io.*; 

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		
		Map<String, Integer> words = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() < M) continue;
			words.put(word, words.getOrDefault(word, 0) + 1);
		}
		
		List<String> keySet = new ArrayList<>(words.keySet());
		keySet.sort((o1, o2) -> {
			if(words.get(o1) != words.get(o2)) {
				return words.get(o2).compareTo(words.get(o1));
			} else if(o1.length() != o2.length()) {
				return o2.length() - o1.length();
			} else {
				return o1.compareTo(o2);
			}
		});
		
		for(String word : keySet) {
			sb.append(word+"\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
