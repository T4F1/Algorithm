import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<Integer, ArrayList<String>> tm = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int days = (Integer.parseInt(st.nextToken()) - 1) * 7 + Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            hm.put(name, -cost);
            tm.putIfAbsent(days, new ArrayList<>());
            tm.get(days).add(name);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());
            hm.put(name, money + hm.get(name));
        }
        int max = 0, cnt = 0;
        for (int day = 0; day < 70; day++) {
            boolean isPossible = false;
            if (tm.containsKey(day))
                for (String name : tm.get(day))
                    if (hm.get(name) >= 0)
                        isPossible = true;
            if (isPossible)
                cnt++;
            else
                cnt = 0;
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}