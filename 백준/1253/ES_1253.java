import java.io.*;
import java.util.*;

public class ES_1253 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        long[] arr = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(arr);

        int cnt = 0;
        // 처음 두 개의 숫자는 다른 수 두 개의 합으로 나타낼 수 없으므로 패스
        for(int i=0; i<n; i++){
            long number = arr[i];

            int l = 0, r = n-1;
            while(l<r){
                if(l == i){
                    l++;
                    continue;
                }
                if(r == i){
                    r--;
                    continue;
                }
                if(arr[l] + arr[r] < number){
                    l++;
                }
                else if(arr[l] + arr[r] > number){
                    r--;
                }
                else{
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
