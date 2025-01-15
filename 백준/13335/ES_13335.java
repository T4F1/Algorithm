import java.io.*;
import java.util.*;

public class ES_13335 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<w; i++){
            dq.offer(0);
        }

        int totalWeight = 0;
        int cnt = 0;
        int index = 0;
        while(index<n){
            int val = arr[index];
            int curWeight = dq.poll();
            totalWeight -= curWeight;
            if(totalWeight+val <= l){
                dq.add(val);
                totalWeight += val;
                index++;
            }
            else{
                dq.add(0);
            }
            cnt++;
        }

        while(!dq.isEmpty()){
            dq.poll();
            cnt++;
        }

        System.out.println(cnt);
    }
}
