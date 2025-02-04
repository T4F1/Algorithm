import java.util.*;
import java.io.*;

public class Main {	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int idx = Collections.binarySearch(list, arr[i]);
        	if (idx < 0) idx = Math.abs(idx) - 1;
        	if (list.isEmpty() || list.get(list.size() - 1) < arr[i]) list.add(arr[i]);
        	else {
        		list.set(idx, arr[i]);
        	}
        }
        System.out.println(list.size());
    }
    /**
     * 25
10 12 14 11 15 22 1 21 8 24 8 20 3 2 5 6 17 7 16 25 19 23 18 13 3
     */
}
