import java.io.*;
import java.util.*;

public class ES_1613 {
    static int[][] graph;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1; // a가 먼저
            graph[b][a] = -1; // b가 나중
        }

        floyd();

        int s = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (graph[a][b] == 1) {
                sb.append("-1\n");  // a가 b보다 먼저 발생
            } else if (graph[a][b] == -1) {
                sb.append("1\n");   // b가 a보다 먼저 발생
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
    }
}
