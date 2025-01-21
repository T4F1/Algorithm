import java.util.*;
import java.io.*;

public class Main {
	static int[] to;
	static boolean[] visited, finished;
	static int N;
	static int total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			total = 0;
			N = Integer.parseInt(br.readLine());
			to = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				to[i] = idx;
			}
			
			for(int from = 1; from <= N; from++) {
				dfs(from);
			}
			

			sb.append(N - total).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int s) {
		if(visited[s]) return;
		
		visited[s] = true;
		int next = to[s];
		
		if(!visited[next])
			dfs(next);
		else {
			if(!finished[next]) {
				total++;
				for(int i = next; i != s; i = to[i]) 
					total++;
			}
		}
		
		finished[s] = true;
	}
	
}
