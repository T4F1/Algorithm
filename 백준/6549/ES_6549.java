import java.io.*;
import java.util.*;

public class ES_6549 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0)
                break;

            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Deque<Integer> dq = new ArrayDeque<>();
            long answer = 0;
            for(int i=0; i<n; i++){
                while(!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]){
                    int h = arr[dq.pollLast()];
                    long w = dq.isEmpty() ? i : i-dq.peekLast()-1;
                    answer = Math.max(answer, h*w);
                }
                dq.offer(i);
            }

            while(!dq.isEmpty()){
                int h = arr[dq.pollLast()];
                long w = dq.isEmpty() ? n : n-dq.peekLast()-1;
                answer = Math.max(answer, h*w);
            }

            System.out.println(answer);
        }
    }
}
