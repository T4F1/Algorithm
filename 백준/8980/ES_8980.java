import java.util.*;
import java.io.*;

public class ES_8980 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(in.readLine());

        // delivery[i] = {시작, 끝, 개수};
        int[][] delivery = new int[m][3];
        for(int i=0; i<m ; i++){
            st = new StringTokenizer(in.readLine());
            delivery[i][0] = Integer.parseInt(st.nextToken());
            delivery[i][1] = Integer.parseInt(st.nextToken());
            delivery[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(delivery, (a,b) -> {
            if(a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });

        // 넣을 수 있는 개수
        int[] boxes = new int[n+1];
        Arrays.fill(boxes, c);

        int answer = 0;
        for(int i=0; i<m; i++){
            int s = delivery[i][0];
            int e = delivery[i][1];
            int box = delivery[i][2];

            int capacity = Integer.MAX_VALUE;
            for(int j=s; j<e; j++){
                capacity = Math.min(boxes[j], capacity);
            }

            // 각 구간 별 더 담을 수 있는 박스 수 갱신하기
            for(int j=s; j<e; j++){
                boxes[j] -= Math.min(capacity, box);
            }
            answer += Math.min(capacity, box);
        }

        System.out.println(answer);
    }
}
