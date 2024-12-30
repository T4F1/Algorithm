import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, min, totalSum;
	public static int[][] num;
	public static int[] team;
	public static Map<Integer, Integer> map;
	
	public static void recursive(int depth, int start) {
		if (depth == n / 2) {
			int halfSum = 0;
			for (int i = 0; i < n / 2; i++) {
				for (int j = i + 1; j < n / 2; j++) {
					halfSum += num[team[i]][team[j]] + num[team[j]][team[i]];
				}
			}
			int anotherSum = 0;
			List<Integer> list = new ArrayList<>(map.keySet());
			for (int i = 0; i < n / 2; i++) {
				for (int j = i + 1; j < n / 2; j++) {
				anotherSum += num[list.get(i)][list.get(j)] + num[list.get(j)][list.get(i)];
				}
			}
			if (Math.abs(halfSum - anotherSum) < min) {
				min = Math.abs(halfSum - anotherSum);
			}
			return;
		}
		for (int i = start; i < n; i++) {
			map.remove(i);
			team[depth] = i;
			recursive(depth + 1, i + 1);
			map.put(i, i);
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		num = new int[n][n];
		team = new int[n / 2];
		min = n * n * 100;
		totalSum = 0;
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, i);
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(0, 0);
		System.out.println(min);
	}
}
