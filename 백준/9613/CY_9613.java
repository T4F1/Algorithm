
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BJ9613 {
	static int [] numbers;
	static long answer;
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test<T;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			answer = 0;
			numbers = new int[N];
			for(int i=0; i<N;i++) {
				numbers[i] = (Integer.parseInt(st.nextToken()));
			}
			for(int i=0; i<N;i++) {
				for(int j=i+1; j<N;j++) {
					uclide(numbers[i],numbers[j]);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	private static void uclide(int a,int b) {
		while(b>0) {
			if(a<b) {
				int temp = a;
				a = b;
				b = temp;
			}
			int n = a%b;
			if(n==0) {
				answer+=b;
				return;
			}
			a = b;
			b = n;
		}
	}
}