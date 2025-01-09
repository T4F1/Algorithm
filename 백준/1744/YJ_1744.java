import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		long total = 0;
		int idx = n - 1;
		while (idx > 0 && num[idx - 1] >= 0) {
			if (num[idx] * num[idx - 1] > num[idx] + num[idx - 1]) {
				total += num[idx] * num[idx - 1];
				idx--;
			} else {
				total += num[idx];
			}
			idx--;
		}
		if (idx >= 0 && num[idx] > 0) total += num[idx];

		idx = 0;
		while (idx < n - 1 && num[idx + 1] <= 0) {
			if (num[idx] * num[idx + 1] > num[idx] + num[idx + 1]) {
				total += num[idx] * num[idx + 1];
				idx++;
			} else {
				total += num[idx];
			}
			idx++;
		}
		if (idx < n && num[idx] < 0) total += num[idx];

		System.out.println(total);
	}
}
