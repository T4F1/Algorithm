import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {
    static int N = 0;
    static long arr[];
    static long MIN = Long.MAX_VALUE;
    static long solution[] = new long[3];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //정렬
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                long value = arr[left] + arr[right] + arr[i];
                if (Math.abs(value) < Math.abs(MIN)) {
                    MIN = value;
                    solution[0] = arr[i];
                    solution[1] = arr[left];
                    solution[2] = arr[right];
                }
                if (value < 0) {
                    left++;
                } else if (value > 0) {
                    right--;
                } else {
                    break;
                }
            }
        }
        sb.append(solution[0]).append(" ").append(solution[1]).append(" ").append(solution[2]);
        System.out.println(sb);
    }
}
