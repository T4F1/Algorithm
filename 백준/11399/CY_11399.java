import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {
    static int [] arr;
    public static void main(String [] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=1; i<N; i++) {
            arr[i]+=arr[i-1];
        }
        int answer = 0;
        for(int i=0; i<N; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
