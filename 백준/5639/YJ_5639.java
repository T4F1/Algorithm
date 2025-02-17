import java.util.*;
import java.io.*;

public class Main {

//	private static long read() throws Exception {
//		long c, n = System.in.read() & 15;
//		boolean m = n == 13;
//		if (m)
//			n = System.in.read() & 15;
//		while ((c = System.in.read()) >= 48)
//			n = (n << 3) + (n << 1) + (c & 15);
//		return m ? ~n + 1 : n;
//	}
	
//	private static int read() throws Exception {
//		int c, n = System.in.read() & 15;
//		while ((c = System.in.read()) >= 48)
//			n = (n << 3) + (n << 1) + (c & 15);
//		return n;
//	}
	
	static Node root;
	static StringBuilder sb;
	
	public static class Node {
		int e;
		Node left;
		Node right;
		
		Node(int e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void binarySearch(int e, Node node) {
		if (node.e == 0) {
			node.e = e;
		} else if (e < node.e) {
			if (node.left != null) binarySearch(e, node.left);
			else node.left = new Node(e);
		} else {
			if (node.right != null) binarySearch(e, node.right);
			else node.right = new Node(e);
		}
	}
	
	public static void postOrder(Node node) {
		if (node.left != null) postOrder(node.left);
		if (node.right != null) postOrder(node.right);
		sb.append(node.e).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		root = new Node(0);
		String input;
		while ((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			binarySearch(n, root);
		}
		postOrder(root);
		System.out.println(sb);
	}
}
