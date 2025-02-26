import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value;
        TreeNode root = null;
        while ((value = br.readLine()) != null && !value.isEmpty()) {
            int number = Integer.parseInt(value);
            if (root == null) { //처음 루트가 비어있으면
                root = new TreeNode(number); //루트로 지정한다.
            } else { //만약 비어있지 않으면,
                root.insert(number); //트리를 구성한다.
            }
        }
        postOrder(root);
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void insert(int newValue) {
            if (newValue < this.value) { //작으면 왼쪽에 삽입한다.
                if (this.left == null) {
                    this.left = new TreeNode(newValue);
                } else {
                    this.left.insert(newValue);
                }
            } else {
                if (this.right == null) { //크면 오른쪽에 삽입한다.
                    this.right = new TreeNode(newValue);
                } else {
                    this.right.insert(newValue);
                }
            }
        }
    }

    //후위 순회
    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left); //왼
        postOrder(root.right);  //오
        System.out.println(root.value); //루트
    }
}