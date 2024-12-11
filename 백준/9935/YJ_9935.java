import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String explosion = br.readLine();
		int expLength = explosion.length();
        StringBuilder stack = new StringBuilder();

        for (char c : str.toCharArray()) {
            stack.append(c);

            if (stack.length() >= expLength) {
                if (stack.substring(stack.length() - expLength).equals(explosion)) {
                    stack.delete(stack.length() - expLength, stack.length());
                }
            }
        }
        
		System.out.println(stack.length() == 0 ? "FRULA" : stack.toString());
	}
}
