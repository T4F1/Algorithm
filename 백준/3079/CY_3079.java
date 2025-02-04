import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사 {
    static int N, M = 0;
    static long time = Long.MAX_VALUE;

    static long[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //인원수
        times = new long[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(times);
        long start = times[0];
        long end = times[N - 1] * M; //M명 모두 최대시간이 걸릴 때
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (long time : times) {
                if (sum > M) { //오버플로우 방지
                    break;
                }
                sum += mid / time;
            }
            if (sum >= M) {
                time = Math.min(mid, time);
                end = mid - 1; //더 많은 사람을 수용 가능하므로, 시간을 줄여도 됨.
            } else {
                start = mid + 1; //더 많은 사람을 수용해야 하므로 시간을 늘림.
            }
        }
        System.out.println(time);
    }
}
