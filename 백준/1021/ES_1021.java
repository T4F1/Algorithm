import java.io.*;
import java.util.*;

public class ES_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++)
            q.add(i);

        int answer = 0;
        for(int val : arr){
            if(q.peek() == val) {
                q.poll();
                continue;
            }

            int cnt = 0;
            while(q.peek() != val){
                q.add(q.poll());
                cnt++;
            }

            answer += Math.min(cnt, q.size()-cnt);
            q.poll();
        }
        System.out.println(answer);
    }
}
