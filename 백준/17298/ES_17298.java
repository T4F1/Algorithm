import java.io.*;
import java.util.*;

public class ES_17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=n-1; i>=0; i--){
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            answer[i] = dq.isEmpty() ? -1 : arr[dq.peekLast()];
            dq.offer(i);
        }

        StringBuilder ans = new StringBuilder();
        for(int val : answer)
            ans.append(val).append(" ");
        System.out.println(ans);
    }
}
