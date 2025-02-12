import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[2 * N]; //원형큐 배열 두배 확장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i + N] = arr[i];
        }
        int[] count = new int[d + 1]; //초밥 종류별 갯수 저장
        int unique = 0; //윈도우에서 중복되지 않은, 현재 선택된 초밥의 가짓수
        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) { //새로운 초밥이 등장하면,
                unique++; //카운트
            }
            count[arr[i]]++;
        } //초기 k개에 대한 윈도우 세팅
        int maxSushi = unique + (count[c] == 0 ? 1 : 0); //쿠폰 스시 포함 있는지 여부 체크
        for (int i = 0; i < N; i++) {
            int removeIdx = i; //제거할 초밥 위치
            int addIdx = i + k; //새로 추가할 초밥 위치
            if (--count[arr[removeIdx]] == 0) { //윈도우 맨 앞의 초밥을 제거한다. 만약 --count[arr[i]]가 0이 되면, unique--
                unique--;
            }
            if (++count[arr[addIdx]] == 1) { //맨마지막 초밥 추가. 만약 원래 없었다면 추가
                unique++;
            }
            //쿠폰 초밥이 포함되지 않으면 추가로 +1
            maxSushi = Math.max(maxSushi, unique + (count[c] == 0 ? 1 : 0));
        }
        System.out.println(maxSushi);

    }
}