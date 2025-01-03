import java.util.Arrays;
class Solution {
    public int solution(int[][] routes) {
        int count = 1;
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1] ==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1] - o2[1];
        }); //첫번째 기준 오름차순 정렬
        int car = routes[0][1];
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] <= car && routes[i][1] >= car) {
                continue;
            } else {
                count++;
                car = routes[i][1];
            }
        }
        return count;
    }
}