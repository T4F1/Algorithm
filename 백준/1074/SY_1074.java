import java.util.*;
import java.io.*;

public class Main {
	static long R;
	static long C;
	static long cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		R = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long k = 1L << N;
		squareZ(0, 0, k);
	}
	
	private static void squareZ(long r, long c, long N) {
		if(N == 1) {
			System.out.println(cnt);
			return;
		}
		
		boolean isLeft = C < c + N/2;
		boolean isUp = R < r + N/2;
		
		if(isLeft && isUp) { // 1사 분면이라면
			squareZ(r, c, N/2);
		} else if(!isLeft && isUp) { // 2사 분면이라면
			cnt += N/2*N/2;
			squareZ(r, c + N/2, N/2);
		} else if(isLeft && !isUp) { // 3사 분면 이라면
			cnt += N/2*N/2*2;
			squareZ(r + N/2, c, N/2);
		} else {
			cnt += N/2*N/2*3;
			squareZ(r + N/2, c + N/2, N/2);
		}
	}
}
