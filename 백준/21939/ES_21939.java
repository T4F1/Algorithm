import java.util.*;
import java.io.*;

public class ES_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Map<Integer, Integer> problems = new HashMap<>();
        PriorityQueue<Problem> maxP = new PriorityQueue<>((a, b) ->
                a.level != b.level ? b.level - a.level : b.number - a.number);
        PriorityQueue<Problem> minP = new PriorityQueue<>((a, b) ->
                a.level != b.level ? a.level - b.level : a.number - b.number);

        for (int i = 0; i < n; i++) {
            String[] split = in.readLine().split(" ");
            int p = Integer.parseInt(split[0]);
            int l = Integer.parseInt(split[1]);
            problems.put(p,l);
            maxP.add(new Problem(p,l));
            minP.add(new Problem(p,l));
        }

        int m = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] split = in.readLine().split(" ");
            String cmd = split[0];

            if (cmd.equals("recommend")) {
                if (Integer.parseInt(split[1]) == 1) {
                    while(!problems.containsKey(maxP.peek().number)
                            || problems.get(maxP.peek().number) != maxP.peek().level){
                        maxP.poll();
                    }
                    sb.append(maxP.peek().number).append("\n");
                } else {
                    while(!problems.containsKey(minP.peek().number)
                            || problems.get(minP.peek().number) != minP.peek().level){
                        minP.poll();
                    }
                    sb.append(minP.peek().number).append("\n");
                }
            } else if (cmd.equals("add")) {
                int p = Integer.parseInt(split[1]);
                int l = Integer.parseInt(split[2]);
                problems.put(p,l);
                maxP.add(new Problem(p,l));
                minP.add(new Problem(p,l));
            } else if (cmd.equals("solved")) {
                problems.remove(Integer.parseInt(split[1]));
            }
        }
        System.out.println(sb);
    }

    static class Problem {
        public int number;
        public int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }
    }
}
