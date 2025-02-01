import java.io.*;
import java.util.*;

public class ES_1749 {
    static int[][] board;
    static int[][] dp;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        calcSum();
        System.out.println(calcAnswer());
    }

    private static void calcSum(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = board[i][j];
                if(i>0) dp[i][j] += dp[i-1][j];
                if(j>0) dp[i][j] += dp[i][j-1];
                if(i>0 && j>0) dp[i][j] -= dp[i-1][j-1];
            }
        }
    }

    private static int calcAnswer(){
        int answer = Integer.MIN_VALUE;
        for(int h=1; h<n; h++) {
            for(int w=1; w<m; w++) {
                for (int i = h-1; i < n; i++) {
                    for (int j = w-1; j < m; j++) {
                        int cnt = dp[i][j];
                        if(i-h>=0) cnt -= dp[i-h][j];
                        if(j-w>=0) cnt -= dp[i][j-w];
                        if(i-h>=0 && j-w>=0) cnt += dp[i-h][j-w];

                        answer = Math.max(cnt, answer);
                    }
                }
            }
        }
        return answer;
    }
}
