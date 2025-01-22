import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀_프로젝트 {
    static int n; // 학생 수
    static int[] arr; // 선택된 학생들
    static boolean[] visited; // 방문 여부
    static boolean[] finished; // 탐색 완료 여부
    static int count; // 팀에 속한 학생 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(n - count).append("\n"); // 팀에 속하지 못한 학생 수 = 전체 학생 수 - 팀에 속한 학생 수
        }
        System.out.print(sb);
    }

    private static void dfs(int now) {
        visited[now] = true; // 현재 학생 방문 처리
        int next = arr[now]; // 다음 학생

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int temp = next; temp != now; temp = arr[temp]) {
                count++;
            }
            count++;
        }
        finished[now] = true; // 현재 학생 탐색 완료
    }
}

