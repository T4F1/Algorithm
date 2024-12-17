import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static int MOD = 900528;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            hm.put(str.charAt(i), i + 1);
        char[] target = br.readLine().toCharArray();
        int result = 0;
        int len = target.length;
        for (int i = 0; i < len; i++) {
            result *= hm.size();
            result += hm.get(target[i]);
            result %= MOD;
        }
        System.out.println(result);
    }
}