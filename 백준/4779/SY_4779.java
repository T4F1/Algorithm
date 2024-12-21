import java.util.*;
import java.io.*;

public class Main {
	static boolean[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			if(input == null) break;
			int N = Integer.parseInt(input);
			int k = 1;
			for(int i = 0; i<N; i++) {
				k *= 3;
			}
			result = new boolean[k];
			
			cantorSet(0, result.length - 1);
			
			for(int i = 0; i < result.length; i++) {
				if(result[i]) sb.append("-");
				else sb.append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void cantorSet(int l, int r) {
		int length = r - l + 1;
		if(length == 1) {
			result[l] = true;
			return;
		}

		for(int i = l + length/3 - 1; i < r - length/3 + 1; i++)
			result[i] = false;
		
		cantorSet(l, l + length/3 - 1);
		cantorSet(r - length/3 + 1, r);
	}
}
