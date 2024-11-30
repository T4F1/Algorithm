import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int q = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> natural = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
            PriorityQueue<Integer> reversal = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            Map<Integer, Integer> hm = new HashMap<>();
            while (q-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if (oper.equals("I")) {
                    natural.offer(number);
                    reversal.offer(number);
                    hm.put(number, hm.getOrDefault(number, 0) + 1);
                } else {
                    while (!reversal.isEmpty() && !hm.containsKey(reversal.peek()))
                        reversal.poll();
                    while (!natural.isEmpty() && !hm.containsKey(natural.peek()))
                        natural.poll();
                    int target = 0;
                    if (number > 0) {
                        if (reversal.isEmpty())
                            continue;
                        target = reversal.poll();
                    } else {
                        if (natural.isEmpty())
                            continue;
                        target = natural.poll();
                    }
                    hm.put(target, hm.get(target) - 1);
                    if (hm.get(target) == 0)
                        hm.remove(target);
                }
            }
            while (!reversal.isEmpty() && !hm.containsKey(reversal.peek()))
                reversal.poll();
            while (!natural.isEmpty() && !hm.containsKey(natural.peek()))
                natural.poll();
            if (hm.isEmpty())
                sb.append("EMPTY");
            else
                sb.append(reversal.poll()).append(" ").append(natural.poll());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}