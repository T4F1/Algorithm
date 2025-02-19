import java.util.*;
import java.io.*;

public class Main {
	
	static int n, maxVertex, maxWeight;
    static List<List<int[]>> graph;
	static boolean[] visited;
	
	public static void dfs(int v, int weight) {
		if (weight > maxWeight) {
			maxWeight = weight;
            maxVertex = v;
        }
		
		for (int[] edge : graph.get(v)) {
            int nextNode = edge[0];
            int nextWeight = edge[1];
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode, weight + nextWeight);
            }
        }
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			while (v2 != -1) {
				int w = Integer.parseInt(st.nextToken());
				graph.get(v1).add(new int[] { v2, w });
                graph.get(v2).add(new int[] { v1, w });
				v2 = Integer.parseInt(st.nextToken());
			}
		}
		
        visited = new boolean[n + 1];
        maxWeight = 0;
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxWeight = 0;
        visited[maxVertex] = true;
        dfs(maxVertex, 0);

		System.out.println(maxWeight);
	}
}
