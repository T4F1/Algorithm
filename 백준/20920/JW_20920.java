import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() >= m) {
                hm.put(str, hm.getOrDefault(str, 0) + 1);
            }
        }
        ArrayList<String> al = new ArrayList<>(hm.keySet());
        al.sort((o1, o2) -> hm.get(o1) != hm.get(o2) ? hm.get(o2) - hm.get(o1)
                : o1.length() != o2.length() ? o2.length() - o1.length() : o1.compareTo(o2));
        StringBuilder sb = new StringBuilder();
        for (String str : al)
            sb.append(str).append("\n");
        System.out.println(sb);
    }
}