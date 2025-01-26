import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] location = new int[n];
		int[] distance = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			location[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		int now = location[0] + distance[0], idx = 1, cnt = 0;
		while (now < m) {
			int max = now;
			while (idx < n && location[idx] <= now) {
				max = Math.max(max, location[idx] + distance[idx]);
				idx++;
			}
			if (max == now) {
				System.out.println(-1);
				System.exit(0);
			}
			now = max;
			cnt++;
		}
		System.out.println(cnt);
	}
}
