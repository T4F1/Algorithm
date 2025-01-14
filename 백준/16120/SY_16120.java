import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		
		Deque<Character> dq = new ArrayDeque<>();
		String rst = "PPAP";
	
		for(char c : arr.toCharArray()) {			
			dq.add(c);
			if(dq.size() >= 4) {
				char[] a = new char[4];
				for(int i = 3; i >= 0; i--) {
					a[i] = dq.pollLast();
				}
				if(a[0] == 'P' && a[1] == 'P' && a[2] == 'A' && a[3] == 'P' ) {
					dq.add('P');
				} else {
					dq.add(a[0]);
					dq.add(a[1]);
					dq.add(a[2]);
					dq.add(a[3]);
				}
			}
		}
		
		if(dq.size() == 1 && dq.poll() == 'P') rst = "PPAP";
		else rst = "NP";
		System.out.println(rst);
	}
}
