import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long divide = 4294967296L;  // 2^32
	static long [] arr;
	static boolean [] barr;
	static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        long result = 1; 
        barr = new boolean[N+1];
        getPrime();
        
        for(int i=2; i<=N;i++) {
        	if(!barr[i]) {
        	   long power = i;
        	    while(power * i <=N) { //i^k가 N을넘지않도록 거듭제곱계산 
        			power*=i;
        		}
        		result = (result * power) % divide; //long을 넘지 않도록 divide로 나눔 
        	}
         }
        System.out.println(result); 
    }
    private static void getPrime() {
    	for(int i=2; i<=N; i++) {
    		if(barr[i]) {
    			continue;
    		}
    		for(int j=i+i;j<=N;j+=i) {
    			barr[j] = true;
    		}
    	}
    	
    }
}
