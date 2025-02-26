import java.util.*;
import java.io.*;

public class Main {
  
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3 ) + (n << 1) + (c & 15);
		return n;
	}
	
	static int[] inorderIdx, inorder, postorder;
	static StringBuilder sb;
	
	public static void treeSearch(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) return;
		
		int root = postorder[postEnd];
		sb.append(root).append(" ");
		
		int rootIdx = inorderIdx[root];
		int leftSize = rootIdx - inStart;
		
		treeSearch(inStart, rootIdx - 1, postStart, postStart + leftSize - 1); // 루트 왼쪽 서브 트리
		treeSearch(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1); // 루트 오른쪽 서브 트리
	}
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = read();
		inorderIdx = new int[n + 1];
		inorder = new int[n];
		postorder = new int[n];
		for (int i = 0; i < n; i++) {
			inorder[i] = read();
			inorderIdx[inorder[i]] = i;
		}
		for (int i = 0; i < n; i++) {
			postorder[i] = read();
		}
		
		treeSearch(0, n - 1, 0, n - 1);
		System.out.println(sb);
		br.close();
	}
}
