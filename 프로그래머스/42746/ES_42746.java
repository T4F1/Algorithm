import java.util.*;

public class ES_42746 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        if(arr[0].equals("0"))
            return "0";

        return String.join("",arr);
    }
}
