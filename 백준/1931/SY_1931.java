import java.util.*;
import java.io.*;

public class Main {

	private static class Node implements Comparable<Node> {
		public int start;
		public int end;
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.end != o.end) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Node meeting = pq.poll();
		int meetingCnt = 1;
		while(!pq.isEmpty()) {
			if(meeting.end > pq.peek().start) {
				pq.poll();
			} else {
				meeting = pq.poll();
				meetingCnt++;
			}
		}
		
		System.out.println(meetingCnt);
		
		br.close();
	}

}
