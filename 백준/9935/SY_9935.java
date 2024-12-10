import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		String boomer = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			int count = 0;
			stack.push(input.charAt(i));
			
			if(stack.size() >= boomer.length()) {
				
				for(int j = 0; j < boomer.length(); j++) {
					if(stack.get(stack.size() - boomer.length() + j) == boomer.charAt(j)) {
						count++;
					}
				}
				
				if(count == boomer.length()) {
					for(int k = 0; k < boomer.length(); k++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) {
			bw.write("FRULA");
		} else {
			for(char c:stack) {
				sb.append(c);
			}
			bw.write(sb.toString());
			
		}
		
		br.close();
		bw.close();
	}
	
}
