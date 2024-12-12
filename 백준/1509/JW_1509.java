import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] isPalindrome;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        isPalindrome = new boolean[len][len];
        checkAllPalindrome(str);
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++)
                if (isPalindrome[j][i - 1])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
        }
        System.out.println(dp[len]);
    }

    private static void checkAllPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++)
            for (int j = i; j < len; j++) {
                isPalindrome[i][j] = checkPalindrome(str, i, j);
            }
    }

    private static boolean checkPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}