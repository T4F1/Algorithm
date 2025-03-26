import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<int[]>[] G;
	static int[] yny;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		G = new List[N + 1];
		for (int i = 1; i <= N; i++)
			G[i] = new ArrayList<>();

		yny = new int[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			yny[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			G[A].add(new int[] { B, W });
			G[B].add(new int[] { A, W });
		}

		int sum = prim(yny);

		System.out.println(sum);
	}

	public static int prim(int[] yny) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		boolean[] visited = new boolean[N + 1];
		int cnt = 0;
		for (int e : yny) {
			visited[e] = true;
			cnt++;
			for (int[] v : G[e]) {
				pq.offer(v);
			}
		}

		int total = 0;
		while (!pq.isEmpty()) {
			int[] edge = pq.poll();
			if (!visited[edge[0]]) {
				cnt++;
				visited[edge[0]] = true;
				total += edge[1];

				for (int[] v : G[edge[0]]) {
					if (!visited[v[0]])
						pq.offer(v);
				}
			}
			
			if(cnt == N) break;
		}

		return total;
	}
}
