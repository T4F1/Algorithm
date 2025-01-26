import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arrN = new int[N];
		for(int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			result += arrN[i] * (N - i);
		}
		
		System.out.println(result);
		
		
		br.close();
	}

}
