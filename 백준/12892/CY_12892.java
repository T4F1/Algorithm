import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 생일선물 {
    static int N = 0; //인원수
    static long D = 0;
    static Present[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Long.parseLong(st.nextToken());

        arr = new Present[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Present(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        Arrays.sort(arr, (o1, o2) -> Long.compare(o1.p, o2.p));
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i].v;
        }
        long max = Long.MIN_VALUE;
        int left = 0;
        for (int right = 0; right < N; right++) {
            sum += arr[right].v;
            while (arr[right].p - arr[left].p >= D) {
                sum -= arr[left].v;
                left++;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static class Present {
        long p; //가격
        long v; //만족도

        public Present(long p, long v) {
            this.p = p;
            this.v = v;
        }
    }

}
