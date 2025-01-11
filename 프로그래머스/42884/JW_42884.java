import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
        System.out.println(solution(routes));
    }

    private static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            if (min < routes[i][0]) {
                answer++;
                min = routes[i][1];
            }
        }
        return answer;
    }
}