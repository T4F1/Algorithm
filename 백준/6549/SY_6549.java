import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) break; // 0이라면 반복문 종료
			
			int[] g = new int[N];
			for(int i = 0; i < N; i++)
				g[i] = Integer.parseInt(st.nextToken());
			
			Deque<Integer> dq = new ArrayDeque<>();
			long max = 0;
			for(int i = 0; i < N; i++) {
				// 모노톤 증가 스택을 이용한 풀이, 인덱스를 저장한다.
				while(!dq.isEmpty() && g[dq.peek()] >= g[i]) {
					int height = g[dq.peek()]; // 계산하려는 높이 추출
					dq.pop();
					//넓이 추출 방법 : 지금 idx - 1에서 dq.peek() 를 빼서 계산하기
					// 진짜 신박하다
					long width = dq.isEmpty() ? i : i - 1 - dq.peek();
					max = Math.max(max, width * height);
				}
				dq.push(i);
			}
			
			// 다 돌았으니 i가 아니라 N 으로 계산하기
			while(!dq.isEmpty() ) {
				int height = g[dq.peek()];
				dq.pop();
				long width = dq.isEmpty() ? N : N - 1 - dq.peek();
				max = Math.max(max, width * height);
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
