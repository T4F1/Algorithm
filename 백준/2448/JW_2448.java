import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], ' ');
        int k = 0;
        while (n > 3 * 1 << k) {
            k++;
        }
        recursive(k, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(new String(board[i])).append("\n");
        System.out.println(sb);
    }

    private static void recursive(int depth, int y, int x) {
        if (depth == 0) {
            board[y][x] = '*';
            board[y + 1][x - 1] = board[y + 1][x + 1] = '*';
            board[y + 2][x - 2] = board[y + 2][x - 1] = board[y + 2][x] = board[y + 2][x + 1] = board[y + 2][x + 2] = '*';
            return;
        }
        int d = 3 * (int) Math.pow(2, depth - 1);
        recursive(depth - 1, y, x);
        recursive(depth - 1, y + d, x - d);
        recursive(depth - 1, y + d, x + d);
    }
}