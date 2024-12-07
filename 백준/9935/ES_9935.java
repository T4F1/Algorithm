import java.io.*;

public class ES_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String bombStr = in.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if(sb.length() < bombStr.length())
                continue;

            while (sb.length() >= bombStr.length()
                    && sb.substring(sb.length() - bombStr.length(), sb.length())
                    .equals(bombStr)) {
                sb.delete(sb.length() - bombStr.length(), sb.length());
            }
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}