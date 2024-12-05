import java.io.*;
import java.util.*;

public class ES_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<n; i++){
            String word = in.readLine();
            if(word.length()>=m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1,o2) -> {
           if(map.get(o1) != map.get(o2)){
               return map.get(o2) - map.get(o1);
           }
           if(o1.length() != o2.length()){
               return o2.length() - o1.length();
           }
           return o1.compareTo(o2);
        });
        for(String key : keys){
            System.out.println(key);
        }
    }
}
