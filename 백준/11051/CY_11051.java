import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11051 {
	static int mod = 10007;
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long [][] factorial = new long[N+1][N+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) {
					factorial[i][j] = 1;
				}else {
					factorial[i][j] = (factorial[i-1][j-1]+factorial[i-1][j]) % 10007;
				}
			}
		}
		System.out.print(factorial[N][K]);
	}

}
