import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ17213 {
	static int combination(int n, int r) {
		if (r == 0 || n == r) return 1;
		return combination(n-1,r-1) + combination(n-1,r);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		m -= n;
		System.out.println(combination(n+m-1, m));
	}
}
