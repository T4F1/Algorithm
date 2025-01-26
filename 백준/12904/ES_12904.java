import java.io.*;

public class ES_12904 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        StringBuilder t = new StringBuilder(in.readLine());
        boolean result = false;

        while(s.length() < t.length()){
            if(t.charAt(t.length()-1) == 'A'){
                t.deleteCharAt(t.length()-1);
            } else if(t.charAt(t.length()-1) == 'B'){
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if(t.toString().equals(s)) result = true;
        System.out.println(result ? 1 : 0);
    }
}