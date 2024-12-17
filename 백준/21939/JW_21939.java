import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            tm.putIfAbsent(difficulty, new TreeSet<>());
            tm.get(difficulty).add(num);
            hm.put(num, difficulty);
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int p = 0, l = 0;
            switch (oper) {
            case "recommend":
                p = Integer.parseInt(st.nextToken());
                int num = 0;
                if (p == 1) {
                    num = tm.get(tm.lastKey()).last();
                } else {
                    num = tm.get(tm.firstKey()).first();
                }
                sb.append(num).append("\n");
                break;
            case "add":
                p = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                tm.putIfAbsent(l, new TreeSet<>());
                tm.get(l).add(p);
                hm.put(p, l);
                break;
            case "solved":
                p = Integer.parseInt(st.nextToken());
                l = hm.get(p);
                hm.remove(p);
                tm.get(l).remove(p);
                if (tm.get(l).isEmpty())
                    tm.remove(l);
                break;
            }
        }
        System.out.println(sb);
    }
}