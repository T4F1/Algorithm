import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(str.length() - 1) == 'A') {
            System.out.println("NP");
            return;
        }
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (c == 'A') {
                if (!(str.charAt(i + 1) == 'P' && dq.size() >= 2)) {
                    System.out.println("NP");
                    return;
                } else {
                    dq.poll();
                    dq.poll();
                }
            } else
                dq.offerLast(c);
        }
        System.out.println(dq.isEmpty() ? "PPAP" : "NP");
    }
}
