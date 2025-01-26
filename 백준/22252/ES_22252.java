import java.util.*;
import java.io.*;

public class ES_22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        Map<String, PriorityQueue<Integer>> infos = new HashMap<>();
        StringTokenizer st;
        long result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                String name = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                infos.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
                PriorityQueue<Integer> pq = infos.get(name);
                for (int j = 0; j < k; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else if (cmd == 2) {
                String name = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = infos.get(name);
                while (pq != null && !pq.isEmpty() && cnt-- > 0) {
                    result += pq.poll();
                }
            }
        }

        System.out.println(result);
    }
}
