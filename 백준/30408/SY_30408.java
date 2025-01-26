import java.util.*;
import java.io.*;

public class Main {

	private static final Set<Long> set = new HashSet<>();
	private static long M = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
			
		rAdd(N);
		
		if(set.contains(M)) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		
		bw.close();
		br.close();
	}
	
	private static void rAdd(long N) {
		if(set.contains(N)) return;
		set.add(N);
		if(N == 1 || N <= M) return;
		
		if(N%2 == 0) {
			rAdd(N/2);
		} else {
			rAdd((N-1)/2);
			rAdd((N+1)/2);
		}
	}
}
