import java.util.*;
import java.io.*;

public class Main {

	private static final Map<String, PriorityQueue<Integer>> gorillas = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			String name = st.nextToken();
			long M = Long.parseLong(st.nextToken());
			
			if(cmd.equals("1")) {
				if(gorillas.containsKey(name)) {
					PriorityQueue<Integer> info = gorillas.get(name);
					while(st.hasMoreTokens()) {
						info.add(Integer.parseInt(st.nextToken()));
					}
				} else {
					PriorityQueue<Integer> info = new PriorityQueue<>((o1, o2) -> o2 - o1);
					while(st.hasMoreTokens()) {
						info.add(Integer.parseInt(st.nextToken()));
					}
					gorillas.put(name, info);
				}
				
			} else {
				PriorityQueue<Integer> info =  gorillas.get(name);
				if(info == null) {
					continue;
				}
				for(int j = 0; j < M; j++) {
					if(info.isEmpty()) {
						break;
					}		
					result += info.poll();
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
