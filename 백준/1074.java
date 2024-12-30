package org.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int N, R, C, result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        recursive(0, 0, (int) Math.pow(2, N));
    }

    private static void recursive(int r, int c, int size) {
        if (size == 1) {
            System.out.println(result);
            return;
        }
        int newSize = size / 2;
        if (R < r + newSize && C < c + newSize) { //제 1 사분면
            recursive(r, c, newSize);
        }
        if (R < r + newSize && c + newSize <= C) { //제 2
            result += (size * size) / 4;
            recursive(r, c + newSize, newSize);
        }
        if (R >= r + newSize && c + newSize > C) { //제 3
            result += (size * size) / 4 * 2;
            recursive(r + newSize, c, newSize);
        }
        if (R >= r + newSize && c + newSize <= C) { //제 4
            result += (size * size) / 4 * 3;
            recursive(r + newSize, c + newSize, newSize);
        }
    }
}
