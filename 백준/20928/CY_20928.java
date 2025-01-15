package org.bj

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 걷는건_귀찮아 {
    static int N, M, result = 0;
    static int[] arr;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        distance = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int currentDistance = distance[0] + arr[0];
        int currentIdx = 1;
        while (currentDistance < N) {
            int farthest = 0;
            while (currentIdx < N && arr[currentIdx] <= currentDistance) {
                farthest = Math.max(farthest, arr[currentIdx] + distance[currentIdx]);
                currentIdx++;
            }
            if (farthest < currentDistance) {
                System.out.println(-1);
                return;
            }
            currentDistance = farthest;
            result++;
        }
        System.out.println(result);
    }
}
