import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		boolean[] chae = new boolean[n+1];
		for(int i = 0; i < n+1; i++) {
			chae[i] = true;
		}
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(!chae[i]) continue;
			for(int j = 2; j*i <= n; j++) {
				chae[j*i] = false;
			}
		}
		
		Long answer = 1L;
		for(int prime = 2; prime <= n; prime++) {
			if(!chae[prime]) continue;
			Long square = 1L;
			while(square <= n/prime) {
				square *= prime;
			}
			answer = answer*square;
			answer %= 4294967296L;
		}

		System.out.println(answer);
		bw.flush();
		bw.close();
		br.close();
	}
	
}
