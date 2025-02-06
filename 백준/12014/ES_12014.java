import java.io.*;
import java.util.*;

public class ES_12014 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringTokenizer st;

        StringBuilder answer = new StringBuilder();
        for(int tmp=1; tmp<=t; tmp++){
            answer.append("Case #").append(tmp).append("\n");

            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 가장 긴 증가하는 부분 수열
            List<Integer> lis = new ArrayList<>();
            lis.add(arr[0]);
            for(int i=1; i<n; i++) {
                int l = 0, r = lis.size()-1;
                while (l <= r) {
                    int mid = (l+r)/2;
                    if(arr[i] > lis.get(mid)){
                        l = mid+1;
                    }else{
                        r = mid-1;
                    }
                }

                if(l >= lis.size()){
                    lis.add(arr[i]);
                }else{
                    lis.set(l, arr[i]);
                }
            }
            answer.append(lis.size() >= k ? 1 : 0).append("\n");
        }

        System.out.println(answer);
    }
}
