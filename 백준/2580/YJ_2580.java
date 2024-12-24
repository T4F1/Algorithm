import java.util.*;
import java.io.*;

public class Main {

	public static int[][] sudoku = new int[9][9];
	
	public static boolean isValid(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == num) return false;
		}
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == num) return false;
		}
		int xBlock = 3 * (x / 3);
		int yBlock = 3 * (y / 3);
		for (int i = xBlock; i < xBlock + 3; i++) {
			for (int j = yBlock; j < yBlock + 3; j++) {
				if (sudoku[i][j] == num) return false;
			}
		}
		return true;
	}
	
	public static void recursive(int x, int y) {
		if (y >= 9) {
			x++;
			y = 0;
		}
		if (x >= 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if (sudoku[x][y] != 0)  {
			recursive(x, y + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isValid(x, y, i)) {
					sudoku[x][y] = i;
					recursive(x, y + 1);
					sudoku[x][y] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(0, 0);
	}
}
