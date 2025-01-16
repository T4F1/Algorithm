import java.io.*;
import java.util.*;

public class ES_2573 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while(true){
            int iceCount = 0;
            for(int i=0; i<n; i++)
                Arrays.fill(visited[i],false);

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j] && map[i][j] > 0) {
                        countIceBFS(i,j);
                        iceCount++;
                    }
                }
            }
            if(iceCount == 0){
                answer = 0;
                break;
            }
            if(iceCount >= 2){
                break;
            }

            melt();
            answer++;
        }
        System.out.println(answer);
    }

    private static void countIceBFS(int startX, int startY){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }

    private static void melt(){
        int[][] melted = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] > 0){
                    int meltCnt = 0;
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(isValid(nx,ny) && map[nx][ny] == 0){
                            meltCnt++;
                        }
                    }
                    melted[i][j] = Math.max(0, map[i][j] - meltCnt);
                }
            }
        }
        map = melted;
    }

    private static boolean isValid(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

}
