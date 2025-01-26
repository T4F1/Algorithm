import java.util.*;
import java.io.*;

public class ES_1074 {
    static int r, c;
    static int ans;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursion(1<<n, 0, 0);
        System.out.println(ans);
    }

    private static void recursion(int size, int startX, int startY){
        if(size == 1){
            if(startX == r && startY == c){
                ans = cnt;
            }
            cnt++;
            return;
        }
        int half = size/2;
        if(startX+half > r && startY+half > c) {
            recursion(half, startX, startY);
        }
        if(startX+half > r && startY+half <= c) {
            cnt += half * half;
            recursion(half, startX, startY+half);
        }
        if(startX+half <= r && startY+half > c) {
            cnt += 2 * half * half;
            recursion(half, startX+half, startY);
        }
        if(startX+half <= r && startY+half <= c) {
            cnt += 3 * half * half;
            recursion(half, startX + half, startY + half);
        }
    }
}