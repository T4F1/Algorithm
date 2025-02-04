import java.io.*;
import java.util.*;

public class ES_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        for (int i = 0; i < n; i++) {
            int l = 0, r = lis.size() - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (lis.get(mid) < arr[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if(l >= lis.size())
                lis.add(arr[i]);
            else lis.set(l, arr[i]);
        }

        System.out.println(lis.size());
    }
}
