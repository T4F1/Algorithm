import java.util.*;
import java.io.*;

public class Main {

	public static int n;
	public static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] tree = new int[n];
		distance = new int[n - 1];
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
			if (i > 0) {
				distance[i - 1] = tree[i] - tree[i - 1];
			}
		}
		int gcd = findGcd(0);
		System.out.println((tree[n - 1] - tree[0]) / gcd + 1 - n);

	}

	public static int findGcd(int i) {
		if (i == n - 3) {
			return gcd(distance[i], distance[i + 1]);
		}
		return gcd(distance[i], findGcd(i + 1));
	}

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
