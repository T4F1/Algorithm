import java.util.*;
import java.io.*;

public class ES_1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++)
            pq.add(Integer.parseInt(in.readLine()));

        int result = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            result += a+b;
            pq.add(a+b);
        }

        System.out.println(result);
    }
}
