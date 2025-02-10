import java.io.*;
import java.util.*;

public class ES_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[index] = arr[i][0] + arr[j][1];
                cd[index++] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(cd);
        long answer = 0;
        for (int val : ab) {
            answer += (upperBound(-val, cd) - lowerBound(-val, cd));
        }

        System.out.println(answer);
    }

    private static int upperBound(int val, int[] cd) {
        int l = 0, r = cd.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (cd[mid] > val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int lowerBound(int val, int[] cd) {
        int l = 0, r = cd.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (cd[mid] >= val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
