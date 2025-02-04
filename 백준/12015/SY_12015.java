import java.util.*;
import java.io.*;

public class Main {
	static int[] ra;
	static int N, M, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int[] lis = new int[N];
		for (int i = 0; i < N; i++) {
			// 이분 탐색 하기
			int start = 0, end = idx - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (arr[i] <= lis[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}

			
			lis[start] = arr[i];
			if (start == idx)
				idx++;
		}
		
		System.out.println(idx);
	}

}
