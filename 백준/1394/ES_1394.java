import java.util.*;
import java.io.*;

public class ES_1394 {
    static int MOD = 900528;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();

        String words = in.readLine();
        int base = words.length();
        for(int i=0; i<words.length(); i++){
            map.put(words.charAt(i),i+1);
        }

        String password = in.readLine();

        long result = 0;
        for(int i=0; i<password.length(); i++){
            result = (result * base + map.get(password.charAt(i))) % MOD;
        }
        System.out.println(result);
    }
}
