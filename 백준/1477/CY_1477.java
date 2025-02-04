import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 휴게소_세우기 {
    static int N, M, L = 0;
    static int[] rests;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        rests = new int[N + 2];
        rests[0] = 0;
        for (int i = 1; i <= N; i++) { //N= 0이므로 이 루프는 실행되지 않음.
            rests[i] = Integer.parseInt(st.nextToken());
        }
        rests[N + 1] = L;
        Arrays.sort(rests);
        int left = 1;
        int right = L - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 1; i <= N + 1; i++) {
                sum += (rests[i] - rests[i - 1] - 1) / mid;
            }
            if (sum > M) { // mid 간격이 너무 작아서 휴게소가 너무 많이 들어간다는 뜻
                left = mid + 1; //키움
            } else { //배치된 휴게소 개수(sum)가 M 이하라면 → mid 간격이 커서 휴게소를 적게 넣을 수 있다는 뜻
                right = mid - 1;
            }
        }
        System.out.println(left);

    }
}
