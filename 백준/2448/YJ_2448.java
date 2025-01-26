import java.util.*;
import java.io.*;

public class Main {
	
	public static char[][] star;
	
	public static void recursive(int depth, int y, int x) {
		if (depth == 0) {
			star[y][x] = '*';
			star[y + 1][x - 1] = '*';
			star[y + 1][x + 1] = '*';
			for (int i = x - 2; i <= x + 2; i++) star[y + 2][i] = '*';
			return;
		}
		
		recursive(depth - 1, y, x);
		recursive(depth - 1, y + 3 * (int)Math.pow(2, depth - 1), x - 3 * (int)Math.pow(2, depth - 1));
		recursive(depth - 1, y + 3 * (int)Math.pow(2, depth - 1), x + 3 * (int)Math.pow(2, depth - 1));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int k = (int)(Math.log(n / 3) / Math.log(2));
		star = new char[n][n * 2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(star[i], ' ');
		}
		recursive(k, 0, n - 1);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 2; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
