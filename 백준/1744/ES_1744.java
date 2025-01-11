import java.io.*;
import java.util.*;

public class ES_1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(in.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int l = 0;
        while(l < n && arr[l] <= 0){
            if(l+1 < n && arr[l+1] < 0){
                answer+= arr[l] * arr[l+1];
                l+=2;
            }
            else break;
        }
        int r = n-1;
        while(r >= 0 && arr[r] > 0){
            if(r-1 >= 0 && arr[r-1] > 0){
                answer += Math.max(arr[r] * arr[r-1], arr[r]+arr[r-1]);
                r -= 2;
            }
            else {
                answer += arr[r];
                r--;
                break;
            }
        }
        if(l==r) answer += arr[l];
        System.out.println(answer);
    }
}
