import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) num[i] = Long.parseLong(st.nextToken());
		Arrays.sort(num);
		int l, r, cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			l = 0; r = n - 1;
			if (r == i) r--;
			if (l == i) l++;
			while (l < r) {
				if (num[i] == num[l] + num[r]) {
					cnt++;
					break;
				}
				else if (num[i] <  num[l] + num[r]) {
					r = r - 1 != i ? r - 1 : r - 2;
				}
				else l = l + 1 != i ? l + 1 : l + 2;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
