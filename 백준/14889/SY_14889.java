import java.util.*;
import java.io.*;

public class Main {
	static List<Integer> pick = new ArrayList<>();
	static int[][] S;
	static int N;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}
		
		recursive(1);
		
		System.out.println(min);
		
	}
	
	private static void recursive(int num) {
		if(pick.size() == N/2) {
			// System.out.println(pick.toString());
			int start = calculate();
			int link = calculate2();
			if(Math.abs(start - link) < min) {
				min = Math.abs(start - link);
			}
		} else {
			for(int i = num; i <= N; i++) {
				if(pick.contains(i)) continue;
				pick.add(i);
				recursive(i);
				pick.remove(Integer.valueOf(i));
			}
		}
	}
	
	private static int calculate() {
		int result = 0;
		for(int i : pick) {
			for(int j : pick) {
				if(i == j) continue;
				result += S[i][j];
			}
		}
		return result;
	}
	
	private static int calculate2() {
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(pick.contains(i)) continue;
			for(int j = 1; j <= N; j++) {
				if(pick.contains(j)) continue;
				if(i == j) continue;
				result += S[i][j];
			}
		}
		return result;
	}
}
