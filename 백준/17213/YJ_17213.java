import java.util.*;
import java.io.*;

public class Main {

	public static int[][] pascal;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		m -= n;
		pascal = new int[n + m][m + 1];
		System.out.println(combination(n + m - 1, m));
	}

	public static int combination(int n, int r) {
		if (pascal[n][r] != 0) {
			return pascal[n][r];
		}
		if (n == r || r == 0) {
			return pascal[n][r] = 1;
		} else {
			pascal[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
		}
		return pascal[n][r];
	}
}

// nHr = (n+r-1)Cr
