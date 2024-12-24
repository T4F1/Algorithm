import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, cnt;
	public static StringBuilder sb;
	
	public static void hanoi(int num, int start, int mid, int end) {
		if (num == 1) {
			sb.append(start + " " + end + "\n");
			cnt++;
			return;
		}
		hanoi(num - 1, start, end, mid);
		sb.append(start + " " + end + "\n");
		cnt++;
		hanoi(num - 1, mid, start, end);
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        cnt = 0;
        hanoi(n, 1, 2, 3);
        System.out.println(cnt + "\n" + sb);
    }
}
