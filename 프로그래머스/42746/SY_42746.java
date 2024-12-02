import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> compareTo(o1, o2));
        
        for(int i = 0; i < numbers.length; i++){
            pq.add(numbers[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(String.valueOf(pq.poll()));
        }
        
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
    
        return sb.toString();
    }

    private int compareTo(int number1, int number2){
        String N = String.valueOf(number1) + String.valueOf(number2);
        String M = String.valueOf(number2) + String.valueOf(number1);

        int result = Integer.parseInt(N) > Integer.parseInt(M) ? -1 : 1;
        return result;
    }
}
