import java.io.*;
import java.util.*;

public class ES_1261 {
    static int m,n;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(in.readLine());
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs(){
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(val -> val[2]));
        q.offer(new int[]{0,0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n-1 && cur[1] == m-1){
                answer = cur[2];
            }

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(isValid(nx,ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0){
                        q.offer(new int[]{nx,ny,cur[2]});
                    }
                    else{
                        q.offer(new int[]{nx,ny,cur[2]+1});
                    }
                }
            }
        }
    }

    static boolean isValid(int x, int y){
        return x < n && x >=0  && y<m && y>=0;
    }
}
