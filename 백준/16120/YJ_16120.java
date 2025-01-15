import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Deque<String> dq = new ArrayDeque<>();
		
		for (int i = 0; i < str.length(); i++) {
			dq.offer(String.valueOf(str.charAt(i)));
			
			if (dq.size() >= 4) {
                String fourth = dq.pollLast();
                String third = dq.pollLast();
                String second = dq.pollLast();
                String first = dq.pollLast();

                if (first.equals("P") && second.equals("P") && third.equals("A") && fourth.equals("P")) {
                    dq.offer("P");
                } else {
                    dq.offer(first);
                    dq.offer(second);
                    dq.offer(third);
                    dq.offer(fourth);
                }
            }
		}
		
		if (dq.toString().replaceAll("[^A-Z]", "").equals("P")) System.out.println("PPAP");
		else System.out.println("NP");
	}
}
