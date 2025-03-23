import java.io.*;
import java.util.*;

public class ES_1507 {
    static int n;
    static int[][] graph;
    static boolean[][] essential;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        graph = new int[n][n];
        essential = new boolean[n][n]; // 필수 간선 여부 체크

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                essential[i][j] = (i < j); // i < j인 경우에만 간선 포함
            }
        }

        if (!floyd()) {
            System.out.println(-1);
            return;
        }

        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (essential[i][j]) {
                    totalCost += graph[i][j];
                }
            }
        }

        System.out.println(totalCost);
    }

    private static boolean floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || i == k || j == k) continue;

                    // 경유해서 가는 비용이 기존 비용보다 작으면 잘못됨
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        return false;
                    }

                    // 경유지를 통해 갈 수 있는 경우 직접 연결이 필수 아님
                    if (graph[i][j] == graph[i][k] + graph[k][j]) {
                        essential[i][j] = false;
                    }
                }
            }
        }
        return true;
    }
}
