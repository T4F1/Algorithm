import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1507 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N][N];

        // 거리 행렬 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 주어진 거리 정보가 최단 거리 조건을 만족하는지 검증
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 0; j < N; j++) {
                    if (j == k || j == i) {
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        // 직접 도로가 필요한 경우만 골라서 총 거리 계산
        int total = 0;
        boolean[][] isNeeded = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean needed = true;
                for (int k = 0; k < N; k++) {
                    if (k != i && k != j && dist[i][j] == dist[i][k] + dist[k][j]) {
                        needed = false;
                        break;
                    }
                }
                if (needed) {
                    total += dist[i][j];
                    isNeeded[i][j] = isNeeded[j][i] = true;
                }
            }
        }

        System.out.println(total);
    }
}
