import java.util.*;
import java.io.*;

public class Main {
	
	public static int n;
	public static boolean[] cantor;
	public static StringBuilder sb;
	
	public static void recursive(int depth, int start) {
		if (depth == 0) {
			return;
		}
		for (int i = start + (int)Math.pow(3, depth - 1); i < start + 2 * (int)Math.pow(3, depth - 1); i++) {
			cantor[i] = false;
		}
		recursive(depth - 1, start);
		recursive(depth - 1, start + (int)Math.pow(3, depth - 1) * 2);
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
        	n = Integer.parseInt(str);
            sb = new StringBuilder();
        	cantor = new boolean[(int)Math.pow(3, n)];
            Arrays.fill(cantor, true);
            recursive(n, 0);
            for (int i = 0; i < cantor.length; i++) {
    			if (cantor[i]) sb.append("-");
    			else sb.append(" ");
    		}
            System.out.println(sb);
        }
    }
}
