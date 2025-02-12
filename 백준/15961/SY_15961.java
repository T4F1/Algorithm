import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N + k - 1];
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		for (int i = N; i < N + k - 1; i++)
			sushi[i] = sushi[i - N];

		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> ate = new HashMap<>();
		for (int i = 0; i < k; i++)
			ate.put(sushi[i], ate.getOrDefault(sushi[i], 0) + 1);
		int len = ate.keySet().size();
		if (!ate.keySet().contains(c))
			len++;
		max = Math.max(max, len);

		int l = 0, r = k - 1;
		while (true) {
			ate.put(sushi[l], ate.get(sushi[l]) - 1);
			if (ate.get(sushi[l]) <= 0)
				ate.remove(sushi[l]);

			l++;
			r++;

			if (r >= N + k - 1)
				break;

			ate.put(sushi[r], ate.getOrDefault(sushi[r], 0) + 1);

			len = ate.keySet().size();
			if (!ate.keySet().contains(c))
				len++;
			max = Math.max(max, len);
		}

		System.out.println(max);
	}
}
