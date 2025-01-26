import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) positive.add(num);
            else negative.add(num);
        }

        // 정렬: 양수는 내림차순, 음수는 오름차순
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int result = 0;

        // 양수 계산
        for (int i = 0; i < positive.size(); i++) {
            if (i + 1 < positive.size() && positive.get(i) > 1 && positive.get(i + 1) > 1) {
                result += positive.get(i) * positive.get(i + 1);
                i++;
            } else {
                result += positive.get(i);
            }
        }

        // 음수 계산
        for (int i = 0; i < negative.size(); i++) {
            if (i + 1 < negative.size()) {
                result += negative.get(i) * negative.get(i + 1);
                i++;
            } else {
                result += negative.get(i);
            }
        }

        System.out.println(result);
    }
}
