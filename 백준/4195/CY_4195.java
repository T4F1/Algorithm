import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 친구_네트워크 {
    static int T, F = 0;
    static HashMap<String, Integer> size;
    static HashMap<String, String> map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
            F = Integer.parseInt(br.readLine());
            size = new HashMap<>();
            map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                map.putIfAbsent(f1, f1); //없으면 부모를 자신으로 지정
                map.putIfAbsent(f2, f2);
                size.putIfAbsent(f1, 1); //키가 존재하지 않으면 1로 사이즈 초기화
                size.putIfAbsent(f2, 1);
                union(f1, f2);
                sb.append(size.get(find(f1))).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static String find(String x) {
        if (x.equals(map.get(x))) {
            return x;
        }
        String root = find(map.get(x));
        map.put(x, root); //경로압축
        return root;
    }

    private static void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);
        if (!rootA.equals(rootB)) { //부모가 다르면
            map.put(rootB, rootA);
            size.put(rootA, size.get(rootA) + size.get(rootB));
        }
    }
}
