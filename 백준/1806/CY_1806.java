import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    static long S = 0;
    static int N = 0;
    static int minLen = Integer.MAX_VALUE;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int left = 0;
        long sum = 0; //부분합
        for (int right = 0; right < N; right++) {
            sum += arr[right];
            while (sum >= S) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left++]; //left를 늘려가며 sum에서 뺀다.
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }
}
