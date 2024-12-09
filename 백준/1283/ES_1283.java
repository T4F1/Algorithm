import java.io.*;
import java.util.*;

public class ES_1283 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Set<Character> keys = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String str = in.readLine();
            String[] words = str.split(" ");
            boolean flag = false; // 키 존재하는지 플래그

            for(int j=0; j<words.length; j++){
                char first = Character.toLowerCase(words[j].charAt(0));
                if(!keys.contains(first)){
                    keys.add(first);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    flag = true;
                    break;
                }
            }

            if(!flag){
                for(int j=0; j<words.length; j++){
                    for(int k=0; k<words[j].length(); k++){
                        char c = Character.toLowerCase(words[j].charAt(k));
                        if(!keys.contains(c)){
                            keys.add(c);
                            words[j] = words[j].substring(0,k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k+1);
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
            }

            sb.append(String.join(" ",words)).append("\n");
        }
        System.out.println(sb);
    }
}
