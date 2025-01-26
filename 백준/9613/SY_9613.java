import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < t; k++) {
			Long result = 0L;
			List<Integer> numbers = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				numbers.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < numbers.size() -1; i++) {
				for(int j = i+1; j < numbers.size(); j++) {
					result += gcd(numbers.get(i), numbers.get(j));
				}
			}
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int gcd(int a, int b) {
		if(a == 0) return b;
		return gcd(b % a, a);
	}
}
