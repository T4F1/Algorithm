import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static StringBuilder sb = new StringBuilder();
    static int[] inorder, postorder, idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inorder = new int[N]; //중위순회
        postorder = new int[N]; //후위순회
        idx = new int[N + 1]; //인오더에서 위치
        /*
        1. 포스트오더에서 루트를 찾는다(맨마지막 요소)
        2. 인오더에서의 루트의 위치를 찾는다(가운데 요소)
        3. 재귀적으로 같은 방식으로 왼쪽, 오른쪽 서브 트리를 처리한다.
            - 서브트리의 루트도 포스트오더의 마지막 값으로 찾는다.
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            idx[inorder[i]] = i; //값의 위치 저장
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        get(0, N - 1, 0, N - 1, sb);
        System.out.println(sb);
    }

    private static void get(int inStart, int inEnd, int postStart, int postEnd, StringBuilder sb) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }
        int root = postorder[postEnd]; //포스트 오더의 마지막 값이 현재 서브트리의 루트
        sb.append(root).append(" ");

        int rootIdx = idx[root];
        int leftSize = rootIdx - inStart; //왼쪽 서브트리 크기

        get(inStart, rootIdx - 1, postStart, postStart + leftSize - 1, sb); //왼쪽 서브트리
        get(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1, sb); //오른쪽 서브트리
    }
}
