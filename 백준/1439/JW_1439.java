import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zero = 0;
        int one = 0;
        if (str.charAt(0) == '0')
            one++;
        else
            zero++;
        for (int i = 0; i < str.length() - 1; i++)
            if (str.charAt(i) == '0' && str.charAt(i + 1) == '1')
                zero++;
            else if (str.charAt(i) == '1' && str.charAt(i + 1) == '0')
                one++;
        System.out.println(Math.min(zero, one));
    }
}