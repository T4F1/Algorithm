import java.util.*;
import java.io.*;

public class ES_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<int[]> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        arr.sort((o1,o2) -> {
            if(o1[1] == o2[1])
                return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        int endTime = arr.get(0)[1];
        int count = 1;
        for(int i=1; i<n; i++){
            int[] times = arr.get(i);
            int start = times[0];
            int end = times[1];

            if(start>=endTime){
                endTime = end;
                count++;
            }
        }

        System.out.println(count);
    }
}
