package org.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ1261 {
    static int N, M = 0;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE); // 최댓값으로 초기화
            char[] carray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = carray[j] - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{0, 0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.pollFirst();
            int x = cur[0];
            int y = cur[1];
            if (x == N - 1 && y == M - 1) {
                return dist[N - 1][M - 1];
            }
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (isValid(cx, cy)) {
                    int newDist = dist[x][y] + map[cx][cy];
                    if (newDist < dist[cx][cy]) {
                        dist[cx][cy] = newDist;
                        if (map[cx][cy] == 0) {
                            pq.addFirst(new int[]{cx, cy}); //0
                        } else {
                            pq.addLast(new int[]{cx, cy});  //1
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
