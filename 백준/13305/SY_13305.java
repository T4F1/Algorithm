import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] edge = new long[N - 1];
		for(int i = 0; i < N - 1; i++) {
			edge[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long[] vertex = new long[N];
		for(int i = 0; i < N; i++) {
			vertex[i] = Integer.parseInt(st.nextToken());
		}
		
		long result = 0;
		long v = vertex[0];
		for(int i = 0; i < N - 1; i++) {
			if(v > vertex[i]) v = vertex[i];
			result += v * edge[i];
		}
		
		System.out.println(result);
	}
	
}
