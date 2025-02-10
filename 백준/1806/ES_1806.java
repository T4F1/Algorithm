import java.io.*;
import java.util.*;

public class ES_1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int l = 0, r = 0, answer = n+1, sum = 0;
        while(true){
            if(sum >= s){
                answer = Math.min(answer, r-l);
                sum -= arr[l++];
            }
            else if(r == n)
                break;
            else
                sum += arr[r++];
        }
        System.out.println(answer == n+1 ? 0 : answer);
    }
}
