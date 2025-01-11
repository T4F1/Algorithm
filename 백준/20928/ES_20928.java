import java.io.*;
import java.util.*;

public class ES_20928 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] p = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] x = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i=0;
        int cnt = 0;
        while(i<n){
            // 최대로 갈 수 있는 곳
            int maxReach = p[i]+x[i];

            if(maxReach>=m){ // 종료
                System.out.println(cnt);
                return;
            }

            int nextIndex = -1;
            for(int j=i+1; j<n; j++){
                if(p[j] > maxReach) continue;

                if(p[j]+x[j] > maxReach){
                    maxReach = p[j]+x[j];
                    nextIndex = j;
                }
            }

            if(nextIndex == -1){
                System.out.println(-1);
                return;
            }

            i = nextIndex;
            cnt++;
        }
        System.out.println(-1);
    }
}
