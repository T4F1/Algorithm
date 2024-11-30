import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int q = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            while (q-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if (oper.equals("I"))
                    tm.put(number, tm.getOrDefault(number, 0) + 1);
                else if (!tm.isEmpty()) {
                    int key = 0;
                    if (number > 0)
                        key = tm.lastKey();
                    else
                        key = tm.firstKey();
                    tm.put(key, tm.get(key) - 1);
                    if (tm.get(key) == 0)
                        tm.remove(key);
                }
            }
            if (tm.isEmpty())
                sb.append("EMPTY");
            else
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}