import java.util.*;
import java.io.*;

public class Main {

	public static int n, max = 0;

	public static int[][] copy(int[][] board) {
		int[][] newBoard = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	
	public static int[][] moveUp(int[][] board) {
		int[][] newBoard = copy(board);

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n - 1; k++) {
					if (newBoard[k][j] != 0) continue;
					newBoard[k][j] = newBoard[k + 1][j];
					newBoard[k + 1][j] = 0;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 1; i++) {
				if (newBoard[i][j] == newBoard[i + 1][j]) {
					newBoard[i][j] = newBoard[i][j] + newBoard[i + 1][j];
					newBoard[i + 1][j] = 0;
					if (newBoard[i][j] > max) 
						max = newBoard[i][j];
					for (int k = 0; k < n - 1; k++) {
						if (newBoard[k][j] != 0) continue;
						newBoard[k][j] = newBoard[k + 1][j];
						newBoard[k + 1][j] = 0;
					}
				}
			}
		}
		
		return newBoard;
	}

	public static int[][] moveDown(int[][] board) {
		int[][] newBoard = copy(board);

		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i >= 0; i--) {
				for (int k = n - 1; k > 0; k--) {
					if (newBoard[k][j] != 0) continue;
					newBoard[k][j] = newBoard[k - 1][j];
					newBoard[k - 1][j] = 0;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i > 0; i--) {
				if (newBoard[i][j] == newBoard[i - 1][j]) {
					newBoard[i][j] = newBoard[i][j] + newBoard[i - 1][j];
					newBoard[i - 1][j] = 0;
					if (newBoard[i][j] > max) max = newBoard[i][j];
					for (int k = n - 1; k > 0; k--) {
						if (newBoard[k][j] != 0) continue;
						newBoard[k][j] = newBoard[k - 1][j];
						newBoard[k - 1][j] = 0;
					}
				}
			}
		}
		
		return newBoard;
	}

	public static int[][] moveLeft(int[][] board) {
		int[][] newBoard = copy(board);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n - 1; k++) {
					if (newBoard[i][k] != 0) continue;
					newBoard[i][k] = newBoard[i][k + 1];
					newBoard[i][k + 1] = 0;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (newBoard[i][j] == newBoard[i][j + 1]) {
					newBoard[i][j] = newBoard[i][j] + newBoard[i][j + 1];
					newBoard[i][j + 1] = 0;
					if (newBoard[i][j] > max) max = newBoard[i][j];
					for (int k = 0; k < n - 1; k++) {
						if (newBoard[i][k] != 0) continue;
						newBoard[i][k] = newBoard[i][k + 1];
						newBoard[i][k + 1] = 0;
					}
				}
			}
		}
		
		return newBoard;
	}

	public static int[][] moveRight(int[][] board) {
		int[][] newBoard = copy(board);
		
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > 0; j--) {				
				for (int k = n - 1; k > 0; k--) {
					if (newBoard[i][k] != 0) continue;
					newBoard[i][k] = newBoard[i][k - 1];
					newBoard[i][k - 1] = 0;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > 0; j--) {
				if (newBoard[i][j] == newBoard[i][j - 1]) {
					newBoard[i][j] = newBoard[i][j] + newBoard[i][j - 1];
					newBoard[i][j - 1] = 0;
					if (newBoard[i][j] > max) max = newBoard[i][j];
					for (int k = n - 1; k > 0; k--) {
						if (newBoard[i][k] != 0) continue;
						newBoard[i][k] = newBoard[i][k - 1];
						newBoard[i][k - 1] = 0;
					}
				}
			}
		}
		
		return newBoard;
	}

	public static void play(int depth, int[][] board) {
		if (depth == 5) {
			return;
		}

		play(depth + 1, moveUp(board));
		play(depth + 1, moveDown(board));
		play(depth + 1, moveRight(board));
		play(depth + 1, moveLeft(board));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > max)
					max = board[i][j];
			}
		}

		play(0, board);
		System.out.println(max);

	}
}
