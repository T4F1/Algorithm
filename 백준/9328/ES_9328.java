import java.io.*;
import java.util.*;

public class ES_9328 {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static List<List<int[]>> doors;
    static boolean[] keys;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(in.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visited = new boolean[h][w];
            keys = new boolean[26];
            doors = new ArrayList<>();
            for(int i=0; i<26; i++)
                doors.add(new ArrayList<>());

            for (int i = 0; i < h; i++) {
                map[i] = in.readLine().toCharArray();
            }

            // 갖고있는 키 목록으로 초기화 하기
            char[] inputKeys = in.readLine().toCharArray();
            if (inputKeys[0] != '0') {
                for (char key : inputKeys) {
                    keys[key-'a'] = true;
                }
            }
            answer.append(bfs()).append("\n");
        }
        System.out.println(answer);
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                // 끝 부분이고 벽이 아닐 경우
                if(isEdge(i,j) && map[i][j] != '*'){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 문서일 때
            if(map[x][y] == '$'){
                count++;
                map[x][y] = '.';
            }
            // 키일 때
            else if(isKey(x,y)){
                int keyIndex = map[x][y]-'a';
                // 키가 없었으면
                if(!keys[keyIndex]) {
                    keys[keyIndex] = true;
                    // 해당 키로 열 수 있는 모든 문들을 큐에 넣기
                    for (int[] door : doors.get(keyIndex)) {
                        q.offer(door);
                    }
                    doors.get(keyIndex).clear(); // 문 모두 땀 처리
                }
                map[x][y] = '.';
            }
            // 문일 때
            else if(isDoor(x,y)){
                int doorIndex = map[x][y]-'A';
                // 키가 없으면
                if(!keys[doorIndex]) {
                    // 잠긴 문 리스트에 해당 좌표 추가
                    doors.get(doorIndex).add(new int[]{x, y});
                    continue;
                }
                map[x][y] = '.';
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return count;
    }

    private static boolean isDoor(int nx, int ny) {
        return Character.isUpperCase(map[nx][ny]);
    }

    private static boolean isKey(int nx, int ny) {
        return Character.isLowerCase(map[nx][ny]);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    private static boolean isEdge(int x, int y) {
        return x == 0 || x == h - 1 || y == 0 || y == w - 1;
    }

}
