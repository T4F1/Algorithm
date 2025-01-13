import java.io.*;
import java.util.*;

public class ES_16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();

        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            dq.offer(c);

            if(dq.size() >= 4){
                Iterator<Character> iterator = dq.descendingIterator();
                char[] temp = new char[4];
                for(int j=0; j<4; j++){
                    temp[3-j] = iterator.next();
                }

                if(temp[0] == 'P' && temp[1] == 'P' && temp[2] == 'A' && temp[3] == 'P'){
                    dq.pollLast();
                    dq.pollLast();
                    dq.pollLast(); // 마지막 P는 어차피 add 했어야 하니까 남겨둠
                }
            }
        }

        if(dq.size() == 1 && dq.peek() == 'P')
            System.out.println("PPAP");
        else
            System.out.println("NP");
    }
}
