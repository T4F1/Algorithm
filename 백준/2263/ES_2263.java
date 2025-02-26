import java.io.*;
import java.util.*;

public class ES_2263 {
    static int[] inOrder, postOrder, index;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        inOrder = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        index = new int[n+1];

        for (int i = 0; i < n; i++) {
            index[inOrder[i]] = i;
        }

        searchTree(0, n - 1, 0, n - 1);
        System.out.println(answer);
    }

    private static void searchTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return;
        }

        int root = postOrder[postRight]; // postOrder의 마지막 값이 루트
        answer.append(root).append(" ");

        int rootIndex = index[root]; // 올바른 root 위치 찾기
        int leftSize = rootIndex - inLeft; // 왼쪽 서브트리 크기

        // 왼쪽 서브트리
        searchTree(inLeft, rootIndex - 1, postLeft, postLeft + leftSize - 1);
        // 오른쪽 서브트리
        searchTree(rootIndex + 1, inRight, postLeft + leftSize, postRight - 1);
    }
}