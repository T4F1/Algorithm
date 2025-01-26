import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// contains
		List<String> words = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			words.add(br.readLine());
		}
		
		Collections.sort(words, (o1, o2) -> {
			return o1.length() - o2.length();
		});
		
		int rst = N;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(words.get(j).startsWith(words.get(i))) {
					rst--;
					break;
				}
			}
		}
		
		System.out.println(rst);
		
		br.close();
	}

}
