import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String charSet = br.readLine();
		String password = br.readLine();
		int charSetSize = charSet.length();
		int passwordSize = password.length();
		Map<String, Integer> hm = new HashMap<>();
		long cnt = 0;
		for (int i = 0; i < charSetSize; i++) {
			hm.put(Character.toString(charSet.charAt(i)), i);
		}
		for (int i = 0; i < passwordSize; i++) {
			cnt += (hm.get(Character.toString(password.charAt(i))) + 1);
			if (i < passwordSize - 1) {
				cnt *= charSetSize;
			}
			cnt = cnt % 900528;
		}
		System.out.println(cnt);
		br.close();
	}
}
