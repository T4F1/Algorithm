package org.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 열쇠 {
    static int h, w;
    static char[][] map;
    static boolean[] keys;
    static boolean[][] visited;
    static List<Point> doors[];
    static Deque<Point> queue = new LinkedList<>();

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            visited = new boolean[h + 2][w + 2];
            keys = new boolean[26];  // 'a' ~ 'z' 열쇠

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            String initialKeys = br.readLine();
            if (!initialKeys.equals("0")) {
                for (char key : initialKeys.toCharArray()) {
                    keys[key - 'a'] = true;
                }
            }

            doors = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }

            int documents = 0;

            // BFS 초기화
            queue.clear();
            queue.add(new Point(0, 0));
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Point curr = queue.poll();
                int x = curr.x, y = curr.y;

                if (map[x][y] == '$') {
                    documents++;  // 문서를 훔침
                } else if ('A' <= map[x][y] && map[x][y] <= 'Z') {
                    // 문을 만났을 때
                    if (!keys[map[x][y] - 'A']) {
                        doors[map[x][y] - 'A'].add(new Point(x, y));
                        continue;  // 열쇠가 없으면 문을 통과하지 않음
                    }
                } else if ('a' <= map[x][y] && map[x][y] <= 'z') {
                    // 열쇠를 만났을 때
                    if (!keys[map[x][y] - 'a']) {
                        keys[map[x][y] - 'a'] = true;
                        for (Point door : doors[map[x][y] - 'a']) {
                            queue.add(door);  // 이 열쇠로 열 수 있는 문을 큐에 추가
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + (i == 0 ? -1 : i == 1 ? 1 : 0);
                    int ny = y + (i == 2 ? -1 : i == 3 ? 1 : 0);

                    if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2 || visited[nx][ny] || map[nx][ny] == '*') {
                        continue;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }

            sb.append(documents).append("\n");
        }

        System.out.print(sb);
    }
}

