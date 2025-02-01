import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][2];

        int max = Integer.MIN_VALUE, mIdx = 0;
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = j;
                    }
                }

            }

            if(dp[i][0] > max){
                max = dp[i][0];
                mIdx = i;
            }
        }

        System.out.println(max);
        StringBuilder sb = new StringBuilder();
        int[] rst = new int[max];
        for(int i = 0; i < max; i++) {
            rst[i] = arr[mIdx];
            mIdx = dp[mIdx][1];
        }

        for(int i = max - 1; i >= 0; i--) {
            sb.append(rst[i]).append(" ");
        }

        System.out.println(sb);
    }
}
