import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 주식_골드2 {
    static int[] arr;
    static int T, N, K, answer = 0;
    static List<Integer> lis = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static String CASE = "Case #";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(CASE).append(test).append("\n");
            for (int num : arr) {
                if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                    lis.add(num);
                } else {
                    int left = 0;
                    int right = lis.size() - 1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (lis.get(mid) < num) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    lis.set(left, num);
                }
            }
            if (lis.size() >= K) {
                answer = 1;
            } else {
                answer = 0;
            }
            lis = new ArrayList<>();
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
