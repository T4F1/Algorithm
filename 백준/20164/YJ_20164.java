import java.util.*;
import java.io.*;

public class Main {

	public static int min, max;

	public static int countOdd(int num) {
		int cnt = 0;
		while (num > 0) {
			if ((num % 10) % 2 != 0)
				cnt++;
			num /= 10;
		}
		return cnt;
	}

	public static void devideNum(int num, int cnt) {
		cnt += countOdd(num);
		if (num < 10) {
			if (cnt > max) max = cnt;
			if (cnt < min) min = cnt;
		} else if (num < 100) {
			int sum = num / 10 + num % 10;
			devideNum(sum, cnt);
		} else {
			String str = String.valueOf(num);
			for (int i = 0; i < str.length() - 2; i++) {
				for (int j = i + 1; j < str.length() - 1; j++) {
					int sum = Integer.parseInt(str.substring(0, i + 1))
							+ Integer.parseInt(str.substring(i + 1, j + 1))
							+ Integer.parseInt(str.substring(j + 1));
					devideNum(sum, cnt);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		max = 0;
		min = n;
		devideNum(n, 0);
		System.out.println(min + " " + max);
	}
}
