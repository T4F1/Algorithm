import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소형기관차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine().trim()); // 객차 수
        int[] passengers = new int[n + 1]; // 승객 수 배열
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            passengers[i] = Integer.parseInt(st.nextToken());
        }

        int p = Integer.parseInt(br.readLine().trim()); // 소형 기관차가 끌 수 있는 최대 객차 수

        int[] prefix = new int[n + 1];  // 누적합 배열
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + passengers[i];
        }

        int[] maxPassengers = new int[n + 1]; // 특정 구간의 최대 승객수
        for (int i = p; i <= n; i++) {
            maxPassengers[i] = prefix[i] - prefix[i - p];
        }

        int[][] dp = new int[n + 1][4];

        for (int train = 1; train <= 3; train++) { // 소형 기관차 1~3대
            for (int i = p; i <= n; i++) { // p번째 객차부터 고려
                dp[i][train] = Math.max(dp[i - 1][train], dp[i - p][train - 1] + maxPassengers[i]);
            }
        }
        System.out.println(dp[n][3]);
    }
}

