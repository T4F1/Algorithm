import java.util.*;
import java.io.*;

public class ES_31869 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> appointment = new LinkedHashMap<>(); // 이름,약속금액
        Map<String ,Integer> date = new HashMap<>();
        int n = Integer.parseInt(in.readLine());
        if(n == 0){
            System.out.println(0);
            return;
        }

        for(int i=0; i<n; i++){
            String[] input = in.readLine().split(" ");
            appointment.put(input[0], Integer.parseInt(input[3]));
            int w = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            date.put(input[0],w*7+d);
        }

        for(int i=0; i<n; i++){
            String[] split = in.readLine().split(" ");
            int asset = Integer.parseInt(split[1]);
            // 약속 금액보다 자산이 적으면 약속을 없앰
            if(appointment.get(split[0]) > asset){
                appointment.remove(split[0]);
                date.remove(split[0]);
            }
        }

        if(date.size() == 0){
            System.out.println(0);
            return;
        }

        int result = 1;
        int before = 0;
        int continuous = 1;
        LinkedList<String> keys = new LinkedList<>(date.keySet());
        keys.sort(Comparator.comparing(date::get));
        for(String name : keys){
            Integer day = date.get(name);
            if(day == before)
                continue;
            if(day-1 == before){
                continuous ++;
                result = Math.max(continuous, result);
            }
            else{
                continuous = 1;
            }
            before = day;
        }

        System.out.println(result);
    }
}
