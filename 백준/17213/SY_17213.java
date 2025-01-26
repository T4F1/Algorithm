import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] pascal = new int[M][M];
		for(int i = 0; i < M; i++) {
			for(int j = 0 ; j <= i; j++) {
				if(i == 0 || j == 0) {
					pascal[i][j] = 1;
 				} else {
 					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
 				}
			}
		}
		
		bw.write(String.valueOf(pascal[M - 1][M - N]));
		
		bw.close();
		br.close();
	}	
}
