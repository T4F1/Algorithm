import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        List<int[]> cameras = new ArrayList<>();
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for(int i = 0; i < routes.length; i++) {
            boolean go = true;
            for(int[] ar : cameras) {
                if(isPossible(ar, routes[i])){
                    go = false;
                    break;
                }
            }
            
            if(go) {
                answer++;
                cameras.add(routes[i]);
            }
        }
        
        return answer;
    }
    
    private boolean isPossible(int[] p1, int[] p2) {
        if(p1[0] <= p2[0] && p1[1] >= p2[0]) return true;
        if(p1[0] <= p2[1] && p1[1] >= p2[1]) return true;
        if(p1[0] >= p2[0] && p1[1] <= p2[1]) return true;
        
        return false;
    }
}
