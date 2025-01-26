import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] trees= new int[N];
		for(int i = 0; i < N ; i++) {
			trees[i] = Integer.parseInt(br.readLine());
		}
		
		int min = 1000000000;
		int GCD = trees[1] - trees[0];
		for(int i = 1; i < N - 1; i++) {
			GCD = gcd(GCD, trees[i+1] - trees[i]);
		}
		
		int result = (trees[N-1] - trees[0])/GCD + 1 - N;
		bw.write(String.valueOf(result));
		
		br.close();
		bw.close();
	}
	
	private static int gcd(int a, int b) {
		if(a == 0) return b;
		return gcd(b % a, a);
	}
}
