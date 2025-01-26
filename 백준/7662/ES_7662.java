import java.util.*;
import java.io.*;

public class ES_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(in.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>(); // 값/중복횟수

            for (int i = 0; i < k; i++) {
                String[] cmd = in.readLine().split(" ");
                String c = cmd[0];
                int d = Integer.parseInt(cmd[1]);

                if (c.equals("I")) {
                    map.put(d, map.getOrDefault(d, 0) + 1);
                } else if (c.equals("D")) {
                    if(map.isEmpty())
                        continue;
                    int key = d == -1 ? map.firstKey() : map.lastKey();
                    if(map.put(key, map.get(key)-1) == 1){
                        map.remove(key);
                    }
                }
            }
            if(map.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(map.lastKey()+" "+map.firstKey());
        }
    }
}
