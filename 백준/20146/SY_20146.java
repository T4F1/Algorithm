import java.util.*;
import java.io.*;


public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		rDivideNumber(br.readLine(), 0);
		
		System.out.println(min + " " + max);
	}
	
	private static void rDivideNumber(String number, int result) {
		
		int oddCnt = countOdd(Integer.parseInt(number));
		
		if(number.length() == 1) { // 한자리라면
			min = Math.min(min, result + oddCnt);
			max = Math.max(max, result + oddCnt);
			
		} else if(number.length() == 2) { // 두자리라면
			int A = Integer.parseInt(number.substring(0, 1));
			int B = Integer.parseInt(number.substring(1, 2));
			rDivideNumber(String.valueOf(A+B), result + oddCnt);

		} else { // 세자리라면
			for(int i = 0; i < number.length() - 2; i++) {
				
				for(int j = i + 1; j < number.length() - 1; j++) {
					int A =  Integer.parseInt(number.substring(0, i+1));
					int B =  Integer.parseInt(number.substring(i+1, j+1));
					int C =  Integer.parseInt(number.substring(j+1));
					
					rDivideNumber(String.valueOf(A+B+C), result + oddCnt);
				}
			}
		}
		
	}
	
	private static int countOdd(int N ) {
		int rst = 0;
		while(N != 0) {
			int tmp = N%10;
			rst += isOdd(tmp);
			N /= 10;
		}
		
		return rst;
	}
	
	private static int isOdd(int N) {
		if(N%2 == 1) {
			return 1;
		}
		return 0;
	}
	
}
