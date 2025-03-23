import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //집하장간 갯수
        int M = Integer.parseInt(st.nextToken()); //집하장간 경로의 갯수
        int[][] arr = new int[N + 1][N + 1];
        int[][] position = new int[N + 1][N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1000 * 1000;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    position[i][j] = j; // 처음에는 직접 연결된 노드로 설정
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int go = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            arr[start][go] = distance;
            arr[go][start] = distance;
            position[start][go] = go;
            position[go][start] = start;
        }
        //플로이드워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        position[i][j] = position[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append("-").append(" ");
                    continue;
                }
                sb.append(position[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
