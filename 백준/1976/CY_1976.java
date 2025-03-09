import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
    static int[] parents;
    static int N, M = 0;
    static String YES = "YES";
    static String NO = "NO";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i; //자기 자신을 부모로 초기화한다.
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        boolean isPossible = true;
        while (st.hasMoreTokens()) { //여행 계획 도시들이 모두 같은 부모인지 확인한다.
            int next = Integer.parseInt(st.nextToken());
            if (find(start) != find(next)) {
                isPossible = false;
                break;
            }
        }
        System.out.println(isPossible ? YES : NO);
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]); //경로 압축
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parents[rootB] = rootA;
        }
    }
}
