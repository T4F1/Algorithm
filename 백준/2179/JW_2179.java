import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();
        int maxlen = 0;
        String str1 = "", str2 = "";
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                int limit = Math.min(arr[i].length(), arr[j].length());
                if (limit < maxlen)
                    continue;
                int len = getPrefixLen(arr[i], arr[j], limit);
                if (len > maxlen) {
                    maxlen = len;
                    str1 = arr[i];
                    str2 = arr[j];
                }
            }
        System.out.println(str1);
        System.out.println(str2);
    }

    private static int getPrefixLen(String str1, String str2, int limit) {
        int len = 0;
        while (len < limit && str1.charAt(len) == str2.charAt(len))
            len++;
        return len;
    }
}