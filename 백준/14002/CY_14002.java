import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열_4 {
    static int maxLen, N = 0;
    static int dp[];
    static int map[];
    static Deque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dp[i] = 1; //인덱스 i를 가지고 만들 수 있는 가장 큰 수열의 길이
            for (int j = 0; j < i; j++) { //i보다 작은 인덱스들
                if (map[j] < map[i]) {//만약 앞 인덱스보다 값이 크면
                    dp[i] = Math.max(dp[j] + 1, dp[i]); //이전 수열의 길이에 1을 더하는 것 vs 현재 dp값
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        sb.append(maxLen).append("\n");
        for (int i = N - 1; i >= 0; i--) {
            if (maxLen == dp[i]) {
                dq.offerLast(map[i]);
                maxLen--;
            }
        }
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}
