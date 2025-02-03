import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] area = new int[n + 2];
        area[0] = 0;
        area[n + 1] = l;
        if (n != 0) {
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= n; i++) {
            	area[i] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(area);
        int left = 1, right = l, answer = l;
        while (left <= right) {
        	int mid = (left + right) / 2;
        	int restTotal = 0;
            for (int i = 0; i <= n; i++) {
        		restTotal += (area[i + 1] - area[i] - 1) / mid;
        	}
        	if (restTotal > m) {
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        		answer = Math.min(answer, mid);
        	}
        }
        System.out.println(answer);
    }
}
