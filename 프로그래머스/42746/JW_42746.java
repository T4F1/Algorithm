import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            strArr[i] = String.valueOf(numbers[i]);
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}