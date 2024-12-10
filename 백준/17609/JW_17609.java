import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(isPalindrome(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                if (isPseudo(str, l + 1, r) || isPseudo(str, l, r - 1))
                    return 1;
                return 2;
            }
            l++;
            r--;
        }
        return 0;
    }

    private static boolean isPseudo(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}