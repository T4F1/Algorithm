import java.io.*;

public class ES_15989 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        int[] nums = new int[t];
        int max = 0;
        for(int i=0; i<t; i++) {
            nums[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max+1];
        dp[0] = 1;
        for(int num=1; num<=3; num++){
            for(int i=num; i<=max; i++){
                dp[i] += dp[i-num];
            }
        }
        for(int num : nums){
            System.out.println(dp[num]);
        }
    }
}
