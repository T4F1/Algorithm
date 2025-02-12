import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {
    static int N, count = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            int num = arr[i];
            while (left < right) {
                if (left == i) { //칸이 같아질경우
                    left++; //칸 건너뜀
                    continue;
                } else if (right == i) { //만약 끝 칸이 같을경우
                    right--;
                    continue;
                } else if (arr[left] + arr[right] > num) {
                    right--;
                } else if (arr[left] + arr[right] < num) {
                    left++; //키움
                } else if (arr[left] + arr[right] == num) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
