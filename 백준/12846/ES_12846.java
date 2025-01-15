import java.io.*;
import java.util.*;

public class ES_12846 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;
        for(int i=0; i<n; i++){
            while(!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]){
                int money = arr[dq.pollLast()];
                int days = dq.isEmpty() ? i : i-dq.peekLast()-1;
                answer = Math.max(answer, days * money);
            }
            dq.offer(i);
        }

        while(!dq.isEmpty()){
            int money = arr[dq.pollLast()];
            int days = dq.isEmpty() ? n : n-dq.peekLast()-1;
            answer = Math.max(answer, days * money);
        }
        System.out.println(answer);
    }
}
