import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BST bst = new BST();

		String line;
		while ((line = br.readLine()) != null) { // EOF까지 반복
			bst.insert(Integer.parseInt(line));
		}

		bst.postorder();
		System.out.println(sb);
	}

	public static class Node {
		Node left;
		Node right;
		int key;

		public Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}

	public static class BST {
		private static Node root;

		public BST() {
			root = null;
		}

		public void insert(int key) {
			root = rInsert(root, key);
		}

		private static Node rInsert(Node root, int key) {
			if (root == null) {
				return new Node(key);
			}

			if (key < root.key) {
				root.left = rInsert(root.left, key);
			} else if (key > root.key) {
				root.right = rInsert(root.right, key);
			}

			return root;
		}

		public static void postorder() {
			rPostorder(root);
		}

		private static void rPostorder(Node root) {
			if (root == null) {
				return;
			}

			rPostorder(root.left);
			rPostorder(root.right);
			sb.append(root.key).append("\n");
		}
	}

}
