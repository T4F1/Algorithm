import java.io.*;
import java.util.*;

public class ES_2457 {
    public static final int START = 301;
    public static final int END = 1201;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] flowers = new int[n][2]; // {시작,종료}
        for(int i=0; i<n; i++){
            int[] inputs = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            flowers[i][0] = inputs[0]*100 + inputs[1];
            flowers[i][1] = inputs[2]*100 + inputs[3];
        }

        Arrays.sort(flowers, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int result = 0;
        int curEnd = START;
        int maxEnd = START;
        int index = 0;
        while(curEnd < END){
            boolean found = false;
            while(index < n && flowers[index][0] <= curEnd){
                maxEnd = Math.max(maxEnd, flowers[index][1]);
                index++;
                found = true;
            }

            if(!found){
                result = 0;
                break;
            }

            curEnd = maxEnd;
            result++;
        }
        System.out.println(result);
    }
}
