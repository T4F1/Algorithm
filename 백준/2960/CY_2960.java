package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9613 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		int arr [] = new int[N+1];
		for(int i=2;i<=N;i++) {
			arr[i] = i;
		}
		for(int i=2; i<=N;i++) {
			for(int j=i;j<=N;j+=i) {
				if(arr[j] == 0) {
					continue;
				}
				if(arr[j]>0) {
					arr[j] = 0; //지움
					count ++;
				}
				if(count == K) {
					System.out.println(j);
					return;
				}
			}
		}

	}

}
