import java.io.*;
import java.util.*;

public class ES_15961 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(in.readLine());
        }
        int answer = 0;

        int[] cnts = new int[d+1]; // 초밥 종류 별 개수 저장
        int curUniqueCnt = 0; // 현재 윈도우 내 종류 수
        for(int i=0; i<k; i++){
            if(cnts[arr[i]] == 0) curUniqueCnt++;
            cnts[arr[i]]++;
        }
        answer = curUniqueCnt + (cnts[c] == 0 ? 1 : 0);

        for(int i=0; i<n; i++){
            int remove = arr[i];
            cnts[remove]--;
            if(cnts[remove] == 0) curUniqueCnt--; // 제거하려는 초밥의 종류가 0개 있으면

            int add = arr[(i+k)%n];
            if(cnts[add] == 0) curUniqueCnt++;
            cnts[add]++;

            int tempCnt = curUniqueCnt;
            if(cnts[c] == 0) tempCnt++; // 현재 윈도우에 쿠폰 초밥 없으면 추가
            answer = Math.max(answer, tempCnt);
        }
        System.out.println(answer);
    }
}
