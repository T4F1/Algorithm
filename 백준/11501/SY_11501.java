import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] stock = new int[M];
			for(int j = 0; j < M; j++) {
				stock[j] = Integer.parseInt(st.nextToken());
			}
			
			long money = 0;
			int max = stock[M - 1];
			for(int j = M - 1; j >= 0; j--) {
				if(stock[j] <= max) {
					money += max - stock[j];
				} else {
					max = stock[j];
				}
			}
			
			sb.append(money).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
