import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    static int[] arr;
    static int[] idxArr;
    static int N = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        idxArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            while (!dq.isEmpty() && dq.peekFirst() <= arr[i]) {
                dq.poll();
            }
            idxArr[i] = dq.isEmpty() ? -1 : dq.peekFirst();
            dq.addFirst(arr[i]);
        }
        for (int i = 0; i < N; i++) {
            sb.append(idxArr[i]).append(" ");
        }
        System.out.println(sb);
    }
}