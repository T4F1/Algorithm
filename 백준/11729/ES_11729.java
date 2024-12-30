import java.io.*;

public class ES_11729 {
    static int n;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        System.out.println((int)Math.pow(2,n)-1);
        hanoi(n,1,2,3);
        System.out.println(answer);
    }

    private static void hanoi(int x, int start, int mid, int end){
        if(x == 1) {
            answer.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(x-1, start, end, mid);
        answer.append(start).append(" ").append(end).append("\n");
        hanoi(x-1, mid, start, end);
    }
}
