package main;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int MOD= 10007;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] pascal = new int[N+1][N+1];
		
		for(int i = 0; i <= N ; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == 0 || j == 0) {
					pascal[i][j] = 1;
				} else {
					pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % MOD;
				}
			}
		}
		
		bw.write(String.valueOf(pascal[N][K]));
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
