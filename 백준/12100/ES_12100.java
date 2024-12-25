import java.io.*;
import java.util.*;

public class ES_12100 {
    static int[][] map;
    static int max=0;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        recursion(0, map);
        System.out.println(max);
    }

    private static void recursion(int depth, int[][] arr){
        if(depth == 5){
            for(int[] r : arr){
                for(int c : r){
                    max = Math.max(max,c);
                }
            }
            return;
        }

        recursion(depth+1, slidUp(arr));
        recursion(depth+1, slidDown(arr));
        recursion(depth+1, slidLeft(arr));
        recursion(depth+1, slidRight(arr));
    }

    private static int[][] slidUp(int[][] arr){
        // 위
        int[][] copyArr = cloneArr(arr);
        for(int i=0; i<n; i++){
            int[] col = new int[n];
            boolean merged = false;
            int index = 0;

            for(int j=0; j<n; j++){
                if(copyArr[j][i] == 0) continue;

                if(!merged && index>0 && col[index-1] == copyArr[j][i]){
                    col[index-1] *= 2;
                    merged = true;
                }else{
                    col[index++] = copyArr[j][i];
                    merged = false;
                }
            }

            for (int j=0; j<n; j++){
                copyArr[j][i] = col[j];
            }
        }
        return copyArr;
    }

    private static int[][] slidDown(int[][] arr){
        // 아래
        int[][] copyArr = cloneArr(arr);
        for(int i=0; i<n; i++){
            int[] col = new int[n];
            boolean merged = false;
            int index = n-1;

            for(int j=n-1; j>=0; j--){
                if(copyArr[j][i] == 0) continue;

                if(!merged && index<n-1 && col[index+1] == copyArr[j][i]){
                    col[index+1] *= 2;
                    merged = true;
                }else{
                    col[index--] = copyArr[j][i];
                    merged = false;
                }
            }

            for (int j=0; j<n; j++){
                copyArr[j][i] = col[j];
            }
        }
        return copyArr;
    }

    private static int[][] slidLeft(int[][] arr){
        // 좌
        int[][] copyArr = cloneArr(arr);
        for(int i=0; i<n; i++){
            int[] row = new int[n];
            boolean merged = false;
            int index = 0;

            for(int j=0; j<n; j++){
                if(copyArr[i][j] == 0) continue;

                if(!merged && index>0 && row[index-1] == copyArr[i][j]){
                    row[index-1] *= 2;
                    merged = true;
                }else{
                    row[index++] = copyArr[i][j];
                    merged = false;
                }
            }

            copyArr[i] = row;
        }
        return copyArr;
    }

    private static int[][] slidRight(int[][] arr){
        // 우
        int[][] copyArr = cloneArr(arr);

        for(int i=0; i<n; i++){
            int[] row = new int[n];
            boolean merged = false;
            int index = n-1;

            for(int j=n-1; j>=0; j--){
                if(copyArr[i][j] == 0) continue;

                if(!merged && index<n-1 && row[index+1] == copyArr[i][j]){
                    row[index+1] *= 2;
                    merged = true;
                }else{
                    row[index--] = copyArr[i][j];
                    merged = false;
                }
            }

            copyArr[i] = row;
        }
        return copyArr;
    }

    private static int[][] cloneArr(int[][] arr) {
        int[][] copyArr = new int[n][n];
        for(int i=0; i<n; i++){
            copyArr[i] = arr[i].clone();
        }
        return copyArr;
    }
}
