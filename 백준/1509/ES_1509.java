import java.io.*;

public class ES_1509 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();
        int[] dp = new int[arr.length];
        dp[0] = 1;

        for(int i=1; i<arr.length; i++){
            dp[i] = i+1;
            for(int j=0; j<=i; j++){
                if(isPalindrome(arr,j,i)){
                    if(j == 0){
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        System.out.println(dp[arr.length-1]);
    }

    private static boolean isPalindrome(char[] arr, int start, int end){
        int l = start;
        int r = end;
        while(l < r){
            if(arr[l] != arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
