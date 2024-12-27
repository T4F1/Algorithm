import java.util.*;
import java.io.*;


public class Main {
	static int maxValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N]; 
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j< N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rGame(arr, 0);
		 System.out.println(maxValue);
	}
	
	private static void rGame(int[][] arr, int depth) {
		if(depth == 5) {
			maxValue = Math.max(maxValue, findMax(arr));
			return;
		}
		
		rGame(moveUp(arr), depth + 1);
		rGame(moveDown(arr), depth + 1);
		rGame(moveLeft(arr), depth + 1);
		rGame(moveRight(arr), depth + 1);
	}
	
	private static int findMax(int[][] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		
		return max;
	}
	
	private static int[][] deepCopy(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length;j++) {
				result[i][j] = arr[i][j];
			}
		}
		
		return result;
	}
	
	private static int[][] moveLeft(int[][] arr) {
		if(arr.length == 1)
			return arr;
		
		int[][] result = deepCopy(arr);
		
		for(int i = 0; i < result.length; i++) { // 위에서 아래로 진행
			Stack<Integer> stack = new Stack<>();
			for(int j = 0; j < result.length; j++) { // 합칠 idx
				// 빈칸이면 슬라이드
				if(result[i][j] == 0) {
					boolean ok = false;
					for(int k = j; k < result.length; k++) {
						if(result[i][k] != 0) {
							ok = true;
							break;
						}
					}
					if(ok) {
						for(int k = j; k < result.length - 1; k++) {
							result[i][k] = result[i][k + 1];
							result[i][k + 1] = 0;
						}
						j--;
						continue;
					}
				}
				
				// 숫자면 계산 시작
				if(stack.size() < 1) {
					stack.push(result[i][j]);
				} else {
					if(stack.pop() == result[i][j]) {
						result[i][j-1] = result[i][j-1] * 2;
						result[i][j] = 0;
						// 앞으로 당기기
						for(int k = j; k < result.length - 1; k++) {
							result[i][k] = result[i][k + 1];
							result[i][k + 1] = 0;
						}		
						j--;
					} else {
						stack.push(result[i][j]);
					}
				}
			}
		}
		
		return result;
	}
	
	private static int[][] moveRight(int[][] arr) {
		if(arr.length == 1)
			return arr;
		
		int[][] result = deepCopy(arr);
		
		
		for(int i = 0; i < result.length; i++) { // 위에서 아래로 진행
			Stack<Integer> stack = new Stack<>();
			for(int j = result.length - 1; j >= 0; j--) { // 합칠 idx
				// 빈칸이면 슬라이드
				if(result[i][j] == 0) {
					boolean ok = false;
					for(int k = j; k >= 0; k--) {
						if(result[i][k] != 0) {
							ok = true;
							break;
						}
					}
					if(ok) {
						for(int k = j; k > 0; k--) {
							result[i][k] = result[i][k - 1];
							result[i][k - 1] = 0;
						}
						j++;
						continue;
					}
				}
				
				// 숫자면 계산 시작
				if(stack.size() < 1) {
					stack.push(result[i][j]);
				} else {
					if(stack.pop() == result[i][j]) {
						result[i][j+1] = result[i][j+1] * 2;
						result[i][j] = 0;
						// 앞으로 당기기
						for(int k = j; k > 0; k--) {
							result[i][k] = result[i][k - 1];
							result[i][k - 1] = 0;
						}	
						j++;
					} else {
						stack.push(result[i][j]);
					}
				}
			}
		}
		
		return result;
	}
	
	private static int[][] moveUp(int[][] arr) {
		if(arr.length == 1)
			return arr;
		
		int[][] result = deepCopy(arr);
		
		
		for(int i = 0; i < result.length; i++) { // 위에서 아래로 진행
			Stack<Integer> stack = new Stack<>();
			for(int j = 0; j < result.length; j++) { // 왼쪽에서 오른쪽으로 진행
				// 빈칸이면 슬라이드
				if(result[j][i] == 0) {
					boolean ok = false;
					for(int k = j; k < result.length; k++) {
						if(result[k][i] != 0) {
							ok = true;
							break;
						}
					}
					if(ok) {
						for(int k = j; k < result.length - 1; k++) {
							result[k][i] = result[k + 1][i];
							result[k + 1][i] = 0;
						}
						j--;
						continue;
					}
				}
				
				// 숫자면 계산 시작
				if(stack.size() < 1) {
					stack.push(result[j][i]);
				} else {
					if(stack.pop() == result[j][i]) {
						result[j-1][i] = result[j-1][i] * 2;
						result[j][i] = 0;
						// 앞으로 당기기
						for(int k = j; k < result.length - 1; k++) {
							result[k][i] = result[k + 1][i];
							result[k + 1][i] = 0;
						}		
						j--;
					} else {
						stack.push(result[j][i]);
					}
				}
			}
		}
		
		return result;
	}
	
	private static int[][] moveDown(int[][] arr) {
		if(arr.length == 1)
			return arr;
		
		int[][] result = deepCopy(arr);
		
		
		for(int i = 0; i < result.length; i++) { // 위에서 아래로 진행
			Stack<Integer> stack = new Stack<>();
			for(int j = result.length - 1; j >= 0; j--) { // 왼쪽에서 오른쪽으로 진행
				// 빈칸이면 슬라이드
				if(result[j][i] == 0) {
					boolean ok = false;
					for(int k = j; k >= 0; k--) {
						if(result[k][i] != 0) {
							ok = true;
							break;
						}
					}
					if(ok) {
						for(int k = j; k > 0; k--) {
							result[k][i] = result[k - 1][i];
							result[k - 1][i] = 0;
						}
						j++;
						continue;
					}
				}
				
				// 숫자면 계산 시작
				if(stack.size() < 1) {
					stack.push(result[j][i]);
				} else {
					if(stack.pop() == result[j][i]) {
						result[j+1][i] = result[j+1][i] * 2;
						result[j][i] = 0;
						// 앞으로 당기기
						for(int k = j; k > 0; k--) {
							result[k][i] = result[k - 1][i];
							result[k - 1][i] = 0;
						}
						j++;
					} else {
						stack.push(result[j][i]);
					}
				}
			}
		}
		
		return result;
	}
}
