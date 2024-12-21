import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		result = new boolean[N][N*2-1];
		
		rStar(0, N-1, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N*2-1; j++) {
				if(result[i][j]) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void rStar(int r, int c, int N) {
		if(N == 3) {
			result[r][c] = true;
			result[r+1][c-1] = true;
			result[r+1][c+1] = true;
			result[r+2][c-2] = true;
			result[r+2][c-1] = true;
			result[r+2][c] = true;
			result[r+2][c+1] = true;
			result[r+2][c+2] = true;
			return;
		} else {
			int cut = N/2;
			rStar(r, c, cut);
			rStar(r + cut, c - cut, cut);
			rStar(r + cut, c + cut, cut);
		}
	}
}
