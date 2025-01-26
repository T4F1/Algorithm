import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
        }

        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    int hardestLevel = map.lastKey();
                    int hardestProblem = map.get(hardestLevel).last();
                    sb.append(hardestProblem).append("\n");
                } else if (x == -1) {
                    int easiestLevel = map.firstKey();
                    int easiestProblem = map.get(easiestLevel).first();
                    sb.append(easiestProblem).append("\n");
                }
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                map.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());

                for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().remove(P)) {
                        if (entry.getValue().isEmpty()) {
                            map.remove(entry.getKey());
                        }
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
