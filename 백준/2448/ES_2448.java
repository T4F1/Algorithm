import java.io.*;

public class ES_2448 {
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        arr = new char[n][2*n-1];
        for(int i=0; i<n; i++)
            for(int j=0; j<2*n-1; j++)
                arr[i][j] = ' ';

        recursion(0, n-1, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<2*n-1; j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursion(int x, int y, int depth){
        if(depth == 3){
            arr[x][y] = '*';
            arr[x+1][y-1] = arr[x+1][y+1] = '*';
            for(int i=y-2; i<=y+2; i++){
                arr[x+2][i] = '*';
            }
            return;
        }

        int nextDepth = depth/2;
        recursion(x, y, nextDepth);
        recursion(x+nextDepth, y-nextDepth, nextDepth);
        recursion(x+nextDepth, y+nextDepth, nextDepth);
    }
}
