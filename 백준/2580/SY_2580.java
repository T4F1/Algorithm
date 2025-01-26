import java.util.*;
import java.io.*;


public class Main {
	static int[][] sudoku;
	
	static final int N = 9;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j< N; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rSudoku();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(sudoku[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static boolean rSudoku() {
		if(endGame()) {
			return true;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(sudoku[i][j] != 0) continue;
				
				// 재귀 시작
				for(int k = 1; k <= N; k++) {
					if(isValidated(sudoku, k, i, j)) {
						sudoku[i][j] = k;
						boolean endResult = rSudoku();
						if(endResult) return true;
						sudoku[i][j] = 0;
					}
				}
				
				return false;
				
			}
		}
		
		return false;
	}
	
	private static boolean endGame() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(sudoku[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	private static boolean isValidated(int[][] arr, int num, int I, int J) {
		arr[I][J] = num;
		
		boolean[] numbers = new boolean[N + 1];
		
		// 세로 판단
		for(int i = 0; i < N; i++) {
			if(arr[i][J] == 0) continue;
			if(!numbers[arr[i][J]]) {
				numbers[arr[i][J]] = true;
			} else {
				arr[I][J] = 0;
				return false;
			}
		}
		
		// 초기화
		for(int i = 0; i <= N; i++)
			numbers[i] = false;
		
		// 가로 판단
		for(int j = 0; j < N; j++) {
			if(arr[I][j] == 0) continue;
			if(!numbers[arr[I][j]]) {
				numbers[arr[I][j]] = true;
			} else {
				arr[I][J] = 0;
				return false;
			}
		}
		
		// 초기화
		for(int i = 0; i <= N; i++)
			numbers[i] = false;
		
		int[] iRange = findRange(findPosition(I));
		int[] jRange = findRange(findPosition(J));
		
		for(int i : iRange) {
			for(int j : jRange) {
				if(arr[i][j] == 0) continue;
				if(!numbers[arr[i][j]]) {
					numbers[arr[i][j]] = true;
				} else {
					arr[I][J] = 0;
					return false;
				}
			}
		}
		
		arr[I][J] = 0;
		return true;
	}
	
	private static int findPosition(int idx) {
		if(idx <= 2) {
			return 0;
		} else if(idx <= 5) {
			return 1;
		}
		return 2;
	}
	
	private static int[] findRange(int P) {
		int[] range = new int[3];
		if(P == 0) {
			for(int i = 0; i < 3; i++) {
				range[i] = i;
			}
		} else if(P == 1) {
			for(int i = 0; i < 3; i++) {
				range[i] = i + 3;
			}
		} else {
			for(int i = 0; i < 3; i++) {
				range[i] = i + 6;
			}
		}
		
		return range;
    }	
}
