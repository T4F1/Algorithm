import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] stock = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				stock[j] = Integer.parseInt(st.nextToken());
			}
			
			long result = 0;
			long max = stock[n - 1];
			for (int j = n - 2; j >= 0; j--) {
				if (max < stock[j]) {
					max = stock[j];
				} else {
					result += max - stock[j];
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
