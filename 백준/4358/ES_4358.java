import java.util.*;
import java.io.*;

public class ES_4358 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();
        long total = 0;
        while(true){
            String name = in.readLine();
            if(name == null)
                break;
            map.put(name, map.getOrDefault(name, 0)+1);
            total ++;
        }

        for(String name : map.keySet()){
            float rate = (float)map.get(name) / total * 100;
            System.out.printf("%s %.4f\n",name,rate);
        }
    }
}
