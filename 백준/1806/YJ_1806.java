import java.util.*;
import java.io.*;

public class Main {
	
	private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }

	public static void main(String[] args) throws Exception {
		int n = read();
		long s = read();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = read();
		}
		int l = 0, r = 0, cnt = Integer.MAX_VALUE;
		long sum = arr[l];
		List<Long> list = new ArrayList<>();
		list.add(arr[l]);
		while (l < n && r < n) {
			if (sum < s) {
				r++;
				if (r < n) {
					list.add(arr[r]);
					sum += arr[r];
				}
			} else {
				cnt = Math.min(cnt, list.size());
				l++;
				if (!list.isEmpty()) sum -= list.remove(0);
			}
		}
		if (cnt == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(cnt);
	}
}
