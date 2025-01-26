import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ9613 {
	static boolean arr [];
	static int num [];
	static List<Integer> print;
	static int N;
	static int MAX = 5000000;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new boolean[MAX+1];
		num = new int[MAX+1];
		for(int i=2;i<=MAX;i++) {
			arr[i] = false;
			num[i] = 0;
		}
		getPrime();
		for(int test =0; test<T;test++) {
			N = Integer.parseInt(st.nextToken());
			print = new ArrayList<>();
			while(true) {
				if(!arr[N]) {
					print.add(N);
					break;
				}
				print.add(num[N]);
				N = N/num[N];
			}
			Collections.sort(print);
			for(int i=0;i <print.size();i++) {
				sb.append(print.get(i)).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}
	private static void getPrime() {
		for(int i=2; i<=MAX;i++) {
			if(arr[i]) {
				continue;
			}
			for(int j=i+i;j<=MAX;j+=i) {
				if(!arr[j]) {
					arr[j] = true; //지움
					num[j] = i; //소수를 기록한다.
				}
			}
		}
	}

}