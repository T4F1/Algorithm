import java.util.*;

public class ES_42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));

        int end = -30000;
        for(int i=0; i<n; i++){
            if(end < routes[i][0]){
                answer ++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}
