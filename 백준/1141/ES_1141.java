import java.io.*;
import java.util.*;

public class ES_1141 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<String> arr = new ArrayList<>();
        while(n-->0){
            arr.add(in.readLine());
        }

        arr.sort((w1,w2) -> Integer.compare(w2.length(), w1.length()));

        Set<String> set = new HashSet<>();
        for(String word : arr){
            if(set.size() == 0){
                set.add(word);
                continue;
            }

            boolean flag = true;
            for(String w : set){
                if(w.startsWith(word)){
                    flag = false;
                    break;
                }
            }

            if(flag) set.add(word);
        }

        System.out.println(set.size());
    }
}
