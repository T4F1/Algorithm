import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2485 {
	static long [] arr;
	static long [] minarr;
	public static void main(String[]args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer =0;
		arr = new long[N];
		minarr = new long[N-1];
		
		for(int i =0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		for(int i =0; i<N-1; i++) {
			minarr[i] = arr[i+1] - arr[i];
		}
		long minus = minarr[0];
		for(int i =1; i<N-1; i++) {
			minus = gcd(minus,minarr[i]);
		}
		long total = 0;
		for(int i =0; i<N-1; i++) {
			total += (minarr[i]/minus -1);
		}
		System.out.println(total);
		
	}
	private static long gcd(long a, long b) {
		if(a<b) {
			long temp = a;
			a = b;
			b = temp;
		}
		while(b>0) {
			long temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}
