import java.util.*;
import java.io.*;

public class Main {
    static int[][] planet;
    static int[] parent, rank;
    static List<int[]> edgeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        planet = new int[N][4]; // 좌표(x, y, z)와 인덱스 정보 추가
        edgeList = new ArrayList<>();
        parent = new int[N];
        rank = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            planet[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
            planet[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
            planet[i][2] = Integer.parseInt(st.nextToken()); // z 좌표
            planet[i][3] = i; // 원래 인덱스 저장
        }

        // x축 정렬 후 엣지 추가
        Arrays.sort(planet, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < N - 1; i++) {
            edgeList.add(new int[]{planet[i][3], planet[i + 1][3], Math.abs(planet[i][0] - planet[i + 1][0])});
        }

        // y축 정렬 후 엣지 추가
        Arrays.sort(planet, Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < N - 1; i++) {
            edgeList.add(new int[]{planet[i][3], planet[i + 1][3], Math.abs(planet[i][1] - planet[i + 1][1])});
        }

        // z축 정렬 후 엣지 추가
        Arrays.sort(planet, Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < N - 1; i++) {
            edgeList.add(new int[]{planet[i][3], planet[i + 1][3], Math.abs(planet[i][2] - planet[i + 1][2])});
        }

        // 가중치 기준 정렬
        Collections.sort(edgeList, Comparator.comparingInt(o -> o[2]));

        // 최소 스패닝 트리 계산 (크루스칼 알고리즘)
        int rst = 0;
        for (int[] edge : edgeList) {
            if (find(edge[0]) != find(edge[1])) {
                rst += edge[2];
                union(edge[0], edge[1]);
            }
        }

        System.out.println(rst);
    }

    // 경로 압축 최적화 find 함수
    public static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    // 랭크 기반 union 함수
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
