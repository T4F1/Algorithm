import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sArr = new String[n];
        for (int i = 0; i < n; i++)
            sArr[i] = br.readLine();
        Arrays.sort(sArr);
        int cnt = n;
        for (int i = 0; i < n - 1; i++)
            if (sArr[i + 1].startsWith(sArr[i]))
                cnt--;
        System.out.println(cnt);
    }
}