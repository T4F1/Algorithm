import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] distance = new int[n - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		int[] oil = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
		
		long price = 0;
		long minOil = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			if (oil[i] < minOil) {
				minOil = oil[i];
			}
			price += minOil * distance[i];
		}
		
		System.out.println(price);
	}
}
