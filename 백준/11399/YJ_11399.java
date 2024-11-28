import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);
		int sum = 0;
		for (int i = 1; i < n; i++) {
			time[i] += time[i - 1];
		}
		for (int i = 0; i < n; i++) {
			sum += time[i];
		}
		System.out.println(sum);
	}
}
