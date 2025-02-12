import java.util.*;
import java.io.*;

public class Main {
	
	private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

	public static void main(String[] args) throws Exception {
		int n = read();
		long d = read();
		long[][] present = new long[n][2];
		for (int i = 0; i < n; i++) {
			present[i][0] = read();
			present[i][1] = read();
		}
		Arrays.sort(present, (o1, o2) -> {
			if (o1[0] != o2[0])
				return Long.compare(o1[0], o2[0]);
			return Long.compare(o1[1], o2[1]);
		});
		int l = 0;
        long sum = 0, maxSum = 0;
        for (int r = 0; r < n; r++) {
            sum += present[r][1];
            while (present[r][0] - present[l][0] >= d) {
                sum -= present[l][1];
                l++;
            }
            maxSum = Math.max(maxSum, sum);
        }
		System.out.println(maxSum);
	}
}
