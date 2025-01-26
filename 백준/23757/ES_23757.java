import java.util.*;
import java.io.*;

public class ES_23757 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        PriorityQueue<Integer> c = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++)
            c.add(Integer.parseInt(st.nextToken()));
        int[] w = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<m; i++){
            int curWant = w[i];
            int curMax = c.poll();
            if(curWant > curMax) {
                System.out.println(0);
                return;
            }
            c.add(curMax-curWant);
        }

        System.out.println(1);
    }
}