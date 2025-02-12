import java.io.*;
import java.util.*;

public class ES_12892 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Long.parseLong(st.nextToken()); // 가격
            arr[i][1] = Long.parseLong(st.nextToken()); // 만족도
        }

        Arrays.sort(arr, Comparator.comparingLong(v -> v[0]));

        int l=0, r=0;
        long sum = 0, answer = 0;
        while(r<n){
            // 두 값의 차가 d보다 작으면
            if(arr[r][0] - arr[l][0] < d){
                sum+= arr[r++][1]; // r의 만족도를 더함
                answer = Math.max(answer, sum); // answer 갱신
            }else {
                sum -= arr[l++][1]; // l의 만족도를 뺌
            }
        }

        System.out.println(answer);
    }
}
