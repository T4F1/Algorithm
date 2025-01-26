import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> gift = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
		Deque<Integer> num = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			gift.offer(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			num.offer(Integer.parseInt(st.nextToken()));
		}
		int result = 1;
		while (!num.isEmpty()) {
			int giftNum = gift.poll();
			int wantNum = num.poll();
			
			if (giftNum < wantNum) {
				result = 0;
				break;
			}
			gift.offer(giftNum - wantNum);
		}
		System.out.println(result);
	}
}
