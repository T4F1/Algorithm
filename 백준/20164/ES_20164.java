import java.io.*;

public class ES_20164 {
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String n = in.readLine();
        recursion(n, 0);
        System.out.println(min+" "+max);
    }

    private static void recursion(String num, int sum){
        for(int i=0; i<num.length(); i++){
            if((num.charAt(i)-'0')%2 == 1)
                sum ++;
        }
        if(num.length() == 1){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        else if (num.length() == 2){
            num = String.valueOf((num.charAt(0)-'0')+(num.charAt(1)-'0'));
            recursion(num, sum);
        }
        else{
            for(int i=1; i<num.length()-1; i++){
                for(int j=i+1; j<num.length(); j++){
                    int num1 = Integer.parseInt(num.substring(0,i));
                    int num2 = Integer.parseInt(num.substring(i,j));
                    int num3 = Integer.parseInt(num.substring(j));
                    recursion(String.valueOf(num1+num2+num3), sum);
                }
            }
        }
    }
}
