import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            recursive(n);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth) {
        if (depth == 0) {
            sb.append("-");
            return;
        }
        recursive(depth - 1);
        sb.append(" ".repeat((int) Math.pow(3, depth - 1)));
        recursive(depth - 1);
    }
}