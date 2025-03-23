import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] G;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		G = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			G[A][B] = true;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(G[i][k] && G[k][j])
						G[i][j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int S = Integer.parseInt(br.readLine());
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(G[A][B])
				sb.append(-1).append("\n");
			else if(G[B][A])
				sb.append(1).append("\n");
			else 
				sb.append(0).append("\n");		
		}
		
		System.out.println(sb);

	}

}
