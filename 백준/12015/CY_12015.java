import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_큰_증가하는_부분_수열_2 {
    static int N = 0;
    static int[] arr;
    static List<Integer> LIS = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LIS.add(arr[0]);

        for (int num : arr) {
            if (LIS.isEmpty() || LIS.get(LIS.size() - 1) < num) {
                LIS.add(num); //LIS 의 마지막 값보다 작으면 추가
            } else {
                int idx = binarySearch(num);
                LIS.set(idx, num);
            }
        }
        System.out.println(LIS.size());
    }

    static int binarySearch(int num) {
        int left = 0;
        int right = LIS.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (LIS.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // target 이 들어갈 위치
    }
}
