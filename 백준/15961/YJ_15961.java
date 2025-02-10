import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[n * 2];
		for (int i = 0; i < n; i++) sushi[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) sushi[n + i] = sushi[i];
		int maxCnt = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(c, 1);
		for (int i = 0; i < k; i++) {
			int cnt = map.containsKey(sushi[i]) ? map.get(sushi[i]) : 0;
			map.put(sushi[i], cnt + 1);
		}
		for (int i = k; i < n * 2; i++) {
			int cnt = map.get(sushi[i - k]) == 1 ? 0 : map.get(sushi[i - k]) - 1;
			if (cnt == 0) map.remove(sushi[i - k]);
			else map.put(sushi[i - k], cnt);
			map.put(sushi[i], map.containsKey(sushi[i]) ? map.get(sushi[i]) + 1 : 1);
			maxCnt = Math.max(maxCnt, map.size());
		}
		System.out.println(maxCnt);
		br.close();
	}
}
