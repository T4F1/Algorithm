import java.io.*;

public class ES_2179 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = in.readLine();
        }

        int maxLen = 0;
        String res1 = "", res2 = "";
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int max = Math.max(arr[i].length(),arr[j].length());
                if(max < maxLen) continue;
                int result = calcPrefixLength(arr[i],arr[j]);
                if(maxLen < result){
                    maxLen = result;
                    res1 = arr[i];
                    res2 = arr[j];
                }
            }
        }
        System.out.println(res1+"\n"+res2);
    }

    private static int calcPrefixLength(String a, String b){
        int minLength = Math.min(a.length(), b.length());
        int cnt = 0;
        for(int i=0; i<minLength; i++){
            if(a.charAt(i) != b.charAt(i)){
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
