import java.util.*;
import java.io.*;

public class ES_11501 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            int n = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long result = 0;
            int max = 0;
            for(int i=n-1; i>=0; i--){
                if(arr[i] > max)
                    max = arr[i];
                else
                    result += max-arr[i];
            }

            System.out.println(result);
        }
    }
}
