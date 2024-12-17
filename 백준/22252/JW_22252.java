import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, PriorityQueue<Integer>> hm = new HashMap<>();
        StringTokenizer st;
        long score = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            if (oper == 1) {
                hm.putIfAbsent(name, new PriorityQueue<>((o1, o2) -> o2 - o1));
                while (k-- > 0)
                    hm.get(name).add(Integer.parseInt(st.nextToken()));
            } else if (hm.containsKey(name)) {
                while (!hm.get(name).isEmpty() && k-- > 0)
                    score += hm.get(name).poll();
            }
        }
        System.out.println(score);
    }
}