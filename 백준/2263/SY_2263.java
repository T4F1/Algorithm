import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] Tree;
	static int[] inorder, postorder;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inorder = new int[N];
		postorder = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			inorder[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			postorder[i] = Integer.parseInt(st.nextToken());

		findPreorder(0, N - 1, 0, N - 1);

	}

	public static void findPreorder(int pStart, int pEnd, int iStart, int iEnd) {
		if(iStart > iEnd) return; 
		if(iStart == iEnd) {
			System.out.print(inorder[iEnd] + " ");
			return;
		}
		// find root
		int root = postorder[pEnd];

		// print root
		System.out.print(root + " ");

		int iRootIdx = 0;
		for (int i = 0; i < N; i++) {
			if (inorder[i] == root) {
				iRootIdx = i;
				break;
			}
		}

		// extract leftChilds
		int right = iRootIdx - 1;
		findPreorder(pStart, pStart + right - iStart, iStart, right);

		// extract rightChilds
		int left = iRootIdx + 1;
		findPreorder(pEnd - 1 - (iEnd - left), pEnd - 1, left, iEnd);
	}

}
