import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        TreeMap<String, Integer> tm = new TreeMap<>();
        int cnt = 0;
        while ((str = br.readLine()) != null) {
            tm.put(str, tm.getOrDefault(str, 0) + 1);
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for (String name : tm.keySet()) {
            double per = (double) (tm.get(name) * 100) / cnt;
            sb.append(name).append(" ").append(String.format("%.4f", per)).append("\n");
        }
        System.out.println(sb);
    }
}