import java.util.*;
import java.io.*;

public class Main {

	private static long read() throws Exception {
		long c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}
	
	private static int lowerBound(long[] arr, long target) {
		int l = 0, r = arr.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (arr[m] < target) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return l;
	}
	
	private static int upperBound(long[] arr, long target) {
		int l = 0, r = arr.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (arr[m] <= target) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return l;
	}

	public static void main(String[] args) throws Exception {
		int n = (int) read();
		long[][] arr = new long[4][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				arr[j][i] = read();
			}
		}
		long[] arr1 = new long[n * n];
		long[] arr2 = new long[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr1[idx] = arr[0][i] + arr[1][j];
				arr2[idx++] = arr[2][i] + arr[3][j];
			}
		}
		Arrays.sort(arr2);	
		long cnt = 0;
		for (long l : arr1) {
			cnt += upperBound(arr2, -l) - lowerBound(arr2, -l);
		}
		System.out.println(cnt);
	}
}
