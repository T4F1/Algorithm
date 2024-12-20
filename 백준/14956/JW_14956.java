import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int k = 0;
        while (n != 1 << k)
            k++;
        int[] pos = recursive(k, m - 1);
        System.out.println(pos[0] + " " + pos[1]);
    }

    private static int[] recursive(int depth, int m) {
        int[] pos = new int[2];
        if (depth <= 1) {
            if (m == 0)
                pos = new int[] { 1, 1 };
            else if (m == 1)
                pos = new int[] { 1, 2 };
            else if (m == 2)
                pos = new int[] { 2, 2 };
            else if (m == 3)
                pos = new int[] { 2, 1 };
            return pos;
        }
        int subLen = 1 << (depth - 1);
        int subCnt = subLen * subLen;
        int type = m / subCnt;
        int[] subGrid = recursive(depth - 1, m - (subCnt * type));
        if (type == 0) {
            pos = new int[] { subGrid[1], subGrid[0] };
        } else if (type == 1) {
            pos = new int[] { subGrid[0], subGrid[1] + subLen };
        } else if (type == 2) {
            pos = new int[] { subGrid[0] + subLen, subGrid[1] + subLen };
        } else if (type == 3) {
            pos = new int[] { (subLen << 1) - subGrid[1] + 1, subLen - subGrid[0] + 1 };
        }
        return pos;
    }
}