import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			sb.append(isP(str)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int isP(String str) {
		int left = 0, right = str.length() - 1;
		char[] arr = str.toCharArray();
		
		int cnt = 0;
		while(left < right) {
			if(arr[left] == arr[right]) {
				left++;
				right--;
			} else {
				boolean leftP = solve(arr, left+1, right);
				boolean rightP = solve(arr, left, right-1);
				if(leftP || rightP) {
					return 1;
				} else {
					return 2;
				}
			}
		}
		
		return 0;
	} 
	
	private static boolean solve(char[] arr, int left, int right) {
		while(left < right) {
			if(arr[left] != arr[right]) {
				return false;
			}
			left++;
			right--;
		}	
		return true;
	}
}
