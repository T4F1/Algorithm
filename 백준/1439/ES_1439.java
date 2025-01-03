import java.io.*;

public class ES_1439 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        char[] chars = s.toCharArray();
        char before = chars[0];
        int cnt = 1;
        for(int i=1; i<s.length(); i++){
            if(chars[i] == before) continue;
            before = chars[i];
            cnt++;
        }
        int answer;
        if(cnt%2 == 0) answer = cnt/2;
        else answer = (int)Math.ceil(cnt/2);

        System.out.println(answer);
    }
}
