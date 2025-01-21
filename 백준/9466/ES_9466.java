import java.io.*;
import java.util.*;

public class ES_9466 {
    static int[] arr;
    static boolean[] visited;
    static boolean[] inCycle;
    static int cycleCnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            int n = Integer.parseInt(in.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            inCycle = new boolean[n+1];
            cycleCnt = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i=1; i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++) {
                if(!visited[i])
                    dfs(i);
            }
            int cnt = n - cycleCnt;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int curNum){
        // 현재 번호가 이미 방문 했었을 경우
        if(visited[curNum]){
            return;
        }

        visited[curNum] = true;
        int nextNum = arr[curNum];

        // 다음 좌표 방문 안했었으면
        if(!visited[nextNum]){
            dfs(nextNum);
        }
        // 다음 좌표 방문 했었고, 사이클 판단이 아직 안됐을 경우
        else if(!inCycle[nextNum]){
            // 사이클 발견
            cycleCnt++; // 팀 있는 사람 수 ++
            for(int i = nextNum; i!= curNum; i = arr[i]){
                cycleCnt++;
            }
        }

        // 현재 노드가 사이클에 있는지 판단 완료
        inCycle[curNum] = true;
    }
}
