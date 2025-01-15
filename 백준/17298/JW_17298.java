import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] answer = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && dq.peekLast() <= arr[i])
                dq.pollLast();
            answer[i] = dq.isEmpty() ? -1 : dq.peekLast();
            dq.offerLast(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer)
            sb.append(i).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
