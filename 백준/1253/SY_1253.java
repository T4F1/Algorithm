import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());

		Arrays.sort(arr);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int l = 0, r = N - 1;
			while (l < r) {
				if (l == i) {
					l++;
					continue;
				} else if (r == i) {
					r--;
					continue;
				} else if (arr[l] + arr[r] < arr[i]) {
					l++;
				} else if (arr[l] + arr[r] > arr[i]) {
					r--;
				} else if (arr[l] + arr[r] == arr[i]) {
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);
	}
}
