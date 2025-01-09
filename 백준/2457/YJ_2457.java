import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			time[i][0] = startMonth * 100 + startDay;
			time[i][1] = endMonth * 100 + endDay;
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		int start = 301;
		int end = 1201;
		int idx = 0;
		int max = 0;
		int cnt = 0;
		while (start < end) {
			boolean flag = false;
			for (int i = idx; i < n; i++) {
				if (time[i][0] > start) break;
				if (max < time[i][1]) {
					max = time[i][1];
					flag = true;
					idx++;
				}
			}
			
			if (flag) {
				start = max;
				cnt++;
			} else {
				break;
			}
		}
		
		if (max < end) System.out.println(0);
		else System.out.println(cnt);
	}
}
