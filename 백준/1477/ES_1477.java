import java.io.*;
import java.util.*;

public class ES_1477 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+2];
        st = new StringTokenizer(in.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;
        arr[n+1] = l;
        Arrays.sort(arr);
        int left = 1;
        int right = l;

        while(left <= right){
            int mid = (left+right)/2;

            int sum = 0;
            for(int i=1; i<n+2; i++){
                sum += (arr[i] - arr[i-1]-1) / mid;
            }
            if(sum > m){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left);
    }
}
