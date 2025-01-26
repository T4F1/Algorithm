import java.util.*;
import java.io.*;

public class ES_2212 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n-1; i++){
            pq.add(arr[i+1]-arr[i]);
        }

        int answer = 0;
        for(int i=0; i<n-k; i++){
            answer+=pq.poll();
        }
        System.out.println(answer);
    }
}
