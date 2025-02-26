import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static List<Integer>[] tree;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[N + 1];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                tree[parent].add(i);
            }
        }
        System.out.println(dfs(0));
    }

    private static int dfs(int node) {
        if (tree[node].isEmpty()) {
            return 0;
        }
        List<Integer> times = new ArrayList<>();
        for (int child : tree[node]) {
            times.add(dfs(child));
        }
        times.sort(Collections.reverseOrder());
        int maxTime = 0;
        for (int i = 0; i < times.size(); i++) {
            //현재까지 전파된 시간 + 전파 순서에 따른 추가 시간
            maxTime = Math.max(maxTime, times.get(i) + i + 1); //i+1 씩 추가
        }
        return maxTime;
    }
}