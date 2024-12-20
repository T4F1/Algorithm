import java.io.*;

public class ES_4779 {
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = in.readLine();
            if (input == null) {
                break;
            }

            int n = Integer.parseInt(input);
            int num = (int) Math.pow(3, n);
            arr = new boolean[num];

            cantor(0,num-1,num/3);

            StringBuilder ans = new StringBuilder();
            for(int i=0; i<num; i++){
                ans.append(!arr[i] ? "-" : " ");
            }
            System.out.println(ans);
        }
    }

    private static void cantor(int start, int end, int x) {
        if (start == end) {
            return;
        }

        int spaceStart = start + x;
        int spaceEnd = end - x;

        for(int i=spaceStart; i<=spaceEnd; i++){
            arr[i] = true;
        }

        cantor(start,spaceStart-1,x/3);
        cantor(spaceEnd+1, end, x/3);
    }
}
