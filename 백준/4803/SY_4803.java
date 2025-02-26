import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		for (int t = 1; true; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int VN = Integer.parseInt(st.nextToken());
			int EN = Integer.parseInt(st.nextToken());
			if (VN == 0 && EN == 0)
				break;

			// init tree
			visited = new boolean[VN + 1];
			Tree = new ArrayList[VN + 1];
			for (int i = 1; i <= VN; i++)
				Tree[i] = new ArrayList<>();

			for (int i = 0; i < EN; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				// add node
				Tree[v1].add(v2);
				Tree[v2].add(v1);
			}

			cnt = 0;
			for (int i = 1; i <= VN; i++) {
				if (visited[i])
					continue;
				cnt++;
				boolean isCycle = dfs(i, 0);
				if (isCycle)
					cnt--;
			}

			sb.append("Case " + t + ": ");
			if (cnt == 0)
				sb.append("No trees.");
			else if (cnt > 1)
				sb.append("A forest of " + cnt + " trees.");
			else
				sb.append("There is one tree.");
			sb.append("\n");

		}

		System.out.println(sb);

	}

	public static boolean dfs(int v, int parent) {
		if (visited[v]) {
			return false;
		}

		visited[v] = true;

		for (int vertex : Tree[v]) {
			if (visited[vertex] && parent != vertex)
				return true;

			if(dfs(vertex, v)) {
				return true;
			}
		}

		return false;
	}

}
