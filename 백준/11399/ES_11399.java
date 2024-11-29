import java.util.*;
import java.io.*;

public class ES_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++)
            pq.add(Integer.parseInt(st.nextToken()));

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += pq.poll()*(n-i);
        }
        System.out.println(sum);
    }
}


