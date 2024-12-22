import java.io.*;
import java.util.*;

public class ES_14889 {
    static int[][] map;
    static int n;
    static int ans = Integer.MAX_VALUE;
    static List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int cur){
        if(arr.size() == n/2){
            calcGap();
            return;
        }
        for(int i=cur+1; i<n; i++){
            arr.add(i);
            dfs(i);
            arr.remove(arr.size()-1);
        }
    }

    private static void calcGap(){
        int team1 = 0;
        int team2 = 0;

        for(int i : arr){
            for(int j : arr){
                if(i != j)
                    team1 += map[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!arr.contains(i) && !arr.contains(j)){
                    team2 += map[i][j];
                }
            }
        }

        ans = Math.min(ans, Math.abs(team1-team2));
    }
}
