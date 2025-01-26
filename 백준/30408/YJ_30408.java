import java.util.*;
import java.io.*;

public class Main {
	
	public static long m;
	public static Set<Long> set;
	
	public static void devide(long n) {
		if (set.contains(n) || n < 1)
			return;
		set.add(n);
		if (n / 2 == 0) devide(n / 2);
		else {
			devide((n - 1) / 2);
			devide((n - 1) / 2 + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		set = new HashSet<>(); 
		devide(n);
		if (set.contains(m)) System.out.println("YES");
		else System.out.println("NO");
		
		br.close();
	}
}
