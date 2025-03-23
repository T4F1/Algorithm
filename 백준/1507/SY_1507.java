import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] G, rst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		rst = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
				rst[i][j] = G[i][j];
			}
				
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j || i == k || k == j)
						continue;

					if (G[i][j] > G[i][k] + G[k][j]) {
						System.out.println(-1);
						return;
					}
					
					if(G[i][j] == G[i][k] + G[k][j])
						rst[i][j] = Integer.MAX_VALUE;
				}

			}
		}
		
		int ans = 0;
		boolean[][] check = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(rst[i][j] != Integer.MAX_VALUE && i != j && !check[i][j]) {
					ans += rst[i][j];
					check[i][j] = check[j][i] = true;
				}
			}
		}
		
		System.out.println(ans);

	}

}
