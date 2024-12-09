import java.io.*;

public class ES_17609 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int i=0; i<t; i++){
            char[] arr = in.readLine().toCharArray();
            int result = 0;

            int l = 0;
            int r = arr.length-1;
            while(l<r){
                if(arr[l] == arr[r]){
                    l++;
                    r--;
                }
                else{
                    if(isPalindrome(arr, l+1, r) || isPalindrome(arr,l,r-1)){
                        result = 1;
                        break;
                    }
                    result = 2;
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static boolean isPalindrome(char[] arr, int l, int r){
        while(l<r){
            if(arr[l] != arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
