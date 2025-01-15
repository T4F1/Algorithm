import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		int[] nge = new int[N];
		for(int i = 0; i < N; i++) {
			nge[i] = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && nge[dq.peek()] < nge[i]) {
				int idx = dq.pop();
				nge[idx] = nge[i];
			}
			dq.push(i);
		}
		
		while(!dq.isEmpty()) nge[dq.pop()] = -1;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(nge[i]).append(" ");
		
		System.out.println(sb.toString());
	}
}
