import java.io.*;
import java.util.*;

public class ES_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long[] arr = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(arr);

        long[] answer = new long[3];
        long minAbs = Long.MAX_VALUE;

        for (int i = 2; i < n; i++) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                long sum = arr[l] + arr[i] + arr[r];
                if (minAbs > Math.abs(sum)) {
                    minAbs = Math.abs(sum);
                    answer[0] = arr[l];
                    answer[1] = arr[r];
                    answer[2] = arr[i];
                }
                if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (long val : answer) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}
