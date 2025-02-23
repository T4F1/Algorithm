import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Tree = new List[N];
		for (int i = 0; i < N; i++)
			Tree[i] = new ArrayList<>();

		// tree sync
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node == -1)
				continue;
			Tree[node].add(i);
		}

		int rst = postorder(0, 0);

		System.out.println(rst);

	}

	public static int postorder(int node, int depth) {
		boolean[] dp = new boolean[N];
		int max = 0;
		
		for (int v : Tree[node]) {
			int rst = postorder(v, depth + 1);
			if (dp[rst]) {
				while (dp[rst])
					rst++;
			}
			dp[rst] = true;
		}

		if (Tree[node].isEmpty())
			return depth;

		for (int i = N - 1; i >= 0; i--) {
			if (dp[i]) {
				max = i;
				break;
			}
		}

		return max;
	}

}
