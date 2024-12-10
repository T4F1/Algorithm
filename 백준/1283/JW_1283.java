import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();
        while (t-- > 0) {
            String[] sArr = br.readLine().split(" ");
            boolean find = false;
            for (int i = 0; i < sArr.length; i++) {
                char c = sArr[i].charAt(0);
                if (hs.contains(Character.toUpperCase(c)) || hs.contains(Character.toLowerCase(c)))
                    continue;
                sArr[i] = sArr[i].replaceFirst(String.valueOf(c), "[" + c + "]");
                hs.add(c);
                find = true;
                break;
            }
            if (!find)
                next: for (int i = 0; i < sArr.length; i++) {
                    for (char c : sArr[i].toCharArray()) {
                        if (c == ' ' || hs.contains(Character.toUpperCase(c)) || hs.contains(Character.toLowerCase(c)))
                            continue;
                        sArr[i] = sArr[i].replaceFirst(String.valueOf(c), "[" + c + "]");
                        hs.add(c);
                        break next;
                    }
                }
            for (String str : sArr)
                sb.append(str).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}