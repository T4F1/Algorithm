import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[][] box = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			box[i][0] = Integer.parseInt(st.nextToken());
			box[i][1] = Integer.parseInt(st.nextToken());
			box[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(box, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

		int total = 0;
		int[] capacity = new int[n];
		Arrays.fill(capacity, c);
		
		for (int i = 0; i < m; i++) {
			 int start = box[i][0];
			 int end = box[i][1];
			 int cnt = box[i][2];
			 
			 int delivery = c;
			 for (int j = start; j < end; j++) {
				 delivery = Math.min(delivery, capacity[j]);
			 }
			 
			 for (int j = start; j < end; j++) {
				 capacity[j] -= Math.min(delivery, cnt);
			 }
			 
			 total += Math.min(delivery, cnt);
		}
		
		System.out.println(total);
	}
}
