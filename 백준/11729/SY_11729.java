import java.util.*;
import java.io.*;

public class Main {
	
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb.append((int)(Math.pow(2, N) - 1)).append("\n");
		rHanoi(N, 1, 3, 2);
		System.out.println(sb.toString());
	}
	
	private static void rHanoi(int N, int from, int to, int temp) {
		if(N == 0) return;
		rHanoi(N-1, from, temp, to);
		sb.append(from + " " + to).append("\n");
		rHanoi(N-1, temp, to, from);	
	}
}
