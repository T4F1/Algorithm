import java.io.*;
import java.util.*;

public class ES_4195 {
    static Map<String, String> network;
    static Map<String, Integer> level;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int f = Integer.parseInt(in.readLine());

            network = new HashMap<>();
            level = new HashMap<>();

            for(int i=0; i<f; i++){
                String[] names = in.readLine().split(" ");

                level.putIfAbsent(names[0], 1);
                level.putIfAbsent(names[1], 1);
                network.putIfAbsent(names[0], names[0]);
                network.putIfAbsent(names[1], names[1]);

                sb.append(union(names[0], names[1])).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int union(String name1, String name2){
        name1 = find(name1);
        name2 = find(name2);

        if(!name1.equals(name2)){
            if(level.get(name1) < level.get(name2)){
                String tmp = name1;
                name1 = name2;
                name2 = tmp;
            }
            network.put(name2, name1);
            level.put(name1, level.get(name1) + level.get(name2));
        }
        return level.get(name1);
    }

    private static String find(String name){
        if(!network.get(name).equals(name))
            network.put(name, find(network.get(name)));
        return network.get(name);
    }
}
