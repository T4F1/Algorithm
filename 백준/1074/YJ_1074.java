import java.util.*;
import java.io.*;

public class Main {

	public static long r, c, cnt = 0;

	public static void recursive(int depth, int x, int y) {
		if (depth == -1) {
			return;
		}
		if (c < x + Math.pow(2, depth) && r < y + Math.pow(2, depth)) {
			recursive(depth - 1, x, y);
		}
		if (c >= x + Math.pow(2, depth) && r < y + Math.pow(2, depth)) {
			cnt += (int)Math.pow(2, depth) * Math.pow(2, depth);
			recursive(depth - 1, x + (int)Math.pow(2, depth), y);
		}
		if (c < x + Math.pow(2, depth) && r >= y + Math.pow(2, depth)) {
			cnt += (int)Math.pow(2, depth) * Math.pow(2, depth) * 2;
			recursive(depth - 1, x , y + (int)Math.pow(2, depth));
		}
		if (c >= x + Math.pow(2, depth) && r >= y + Math.pow(2, depth)) {
			cnt += (int)Math.pow(2, depth) * Math.pow(2, depth) * 3;
			recursive(depth - 1, x + (int)Math.pow(2, depth), y + (int)Math.pow(2, depth));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		recursive(n - 1, 0, 0);
		System.out.println(cnt);
	}
}
