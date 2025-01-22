import java.io.*;
import java.util.*;

public class ES_14503 {
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int answer = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // 0:상/ 1:우/ 2:하/ 3:좌
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<m; j++){
                map[i][j] = tmp[j] == 0; // false : 갈 수 없는 곳, true : 갈 수 있는 곳
            }
        }

        bfs(r,c,d);
        System.out.println(answer);
    }

    private static void bfs(int startX, int startY, int startDirection){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY, startDirection});
        visited[startX][startY] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int direction = cur[2];

            boolean cleaned = false; // 청소 할 곳이 있었는지 확인하는 플래그
            for(int i=0; i<4; i++){
                direction = (direction+3)%4;
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]){
                    cleaned = true;
                    visited[nx][ny] = true;
                    answer++;
                    q.offer(new int[]{nx,ny,direction});
                    break;
                }
            }

            // 청소할 곳이 없었던 경우,
            if(!cleaned){
                int backX = x-dx[cur[2]];
                int backY = y-dy[cur[2]];
                if(isValid(backX, backY) && map[backX][backY])
                    q.offerFirst(new int[]{backX, backY,cur[2]});
                else
                    break;
            }
        }
    }

    private static boolean isValid(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

}
