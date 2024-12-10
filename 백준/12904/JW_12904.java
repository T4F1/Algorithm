import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(), t = br.readLine();
        StringBuilder sb = new StringBuilder(t);
        while (sb.length() != s.length()) {
            char c = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            if (c == 'B')
                sb = sb.reverse();
        }
        System.out.println(sb.toString().equals(s) ? 1 : 0);
    }
}