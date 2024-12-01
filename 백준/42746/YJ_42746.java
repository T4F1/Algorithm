import java.util.*;

class Solution {
    public String solution(int[] numbers) {
         String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String s : strNumbers) {
            sb.append(s);
        }
        if (sb.toString().charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
