import java.io.*;
import java.util.*;

public class ES_2580 {
    static int[][] map = new int[9][9];
    static List<int[]> canFill = new ArrayList<>();
    static boolean solved = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++){
            map[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<9; j++){
                if(map[i][j] == 0)
                    canFill.add(new int[]{i,j});
            }
        }

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int count){
        if(count == canFill.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            solved = true;
            return;
        }

        int r = canFill.get(count)[0];
        int c = canFill.get(count)[1];
        for(int i=1; i<=9; i++){
            if(possible(i, r,c)){
                map[r][c] = i;
                dfs(count+1);
                if(solved) return;
                map[r][c] = 0;
            }
        }
    }

    private static boolean possible(int k, int r, int c){
        // 가로줄 확인
        for(int i=0;  i<9; i++){
            if(map[r][i] == k){
                return false;
            }
        }

        // 세로줄 확인
        for(int i=0; i<9; i++){
            if(map[i][c] == k){
                return false;
            }
        }

        // 칸 확인
        int row = (r/3) * 3;
        int col = (c/3) * 3;
        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                if(map[i][j] == k){
                    return false;
                }
            }
        }

        return true;
    }
}
