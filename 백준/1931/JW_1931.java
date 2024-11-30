import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { read(), read() };
        }
        // 끝나는 시간이 동일한 경우가 있을 수도 있음
        // Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
        // 따라서 시작 시간 기준으로도 정렬
        Arrays.sort(arr, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int cnt = 0, e = 0;
        for (int i = 0; i < n; i++) {
            int s = arr[i][0];
            if (s >= e) {
                cnt++;
                e = arr[i][1];
            }
        }
        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
