import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        char[] check = br.readLine().toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < cArr.length; i++) {
            dq.offerLast(cArr[i]);
            int idx = check.length - 1;
            while (!dq.isEmpty() && idx >= 0 && check[idx] == dq.peekLast()) {
                temp.offerLast(dq.pollLast());
                idx--;
            }
            if (temp.size() == check.length)
                temp.clear();
            while (!temp.isEmpty())
                dq.offerLast(temp.pollLast());
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty())
            sb.append(dq.pollFirst());
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}