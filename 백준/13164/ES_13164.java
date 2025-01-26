import java.io.*;
import java.util.*;

public class ES_13164 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> gaps = new ArrayList<>();
        for(int i = 1; i<n; i++){
            gaps.add(arr[i]-arr[i-1]);
        }
        gaps.sort(Collections.reverseOrder());

        int answer = 0;
        for(int i=k-1; i<n-1; i++){
            answer+=gaps.get(i);
        }

        System.out.println(answer);
    }
}
