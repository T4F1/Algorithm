import java.io.*;
import java.util.*;

public class ES_14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder answer = new StringBuilder();

        int[] dp = new int[n];
        dp[0] = 1;
        int cnt = 1; // 가장 긴 증가하는 수열 길이
        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    cnt = Math.max(cnt, dp[i]);
                }
            }
        }
        answer.append(cnt).append('\n');
        List<Integer> nums = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(dp[i] == cnt){
                nums.add(arr[i]);
                cnt--;
            }
        }
        Collections.reverse(nums);
        for(int val : nums)
            answer.append(val).append(" ");

        System.out.println(answer);
    }
}
