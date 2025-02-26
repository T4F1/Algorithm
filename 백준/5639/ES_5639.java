import java.io.*;

public class ES_5639 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(in.readLine()));
        String s;
        while (true) {
            s = in.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }

            int value = Integer.parseInt(s);
            root.insert(value);
        }
        getOrder(root);
    }

    static void getOrder(Node node) {
        if (node == null) {
            return;
        }
        getOrder(node.left);
        getOrder(node.right);
        System.out.println(node.value);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        void insert(int number) {
            if (number < this.value) {
                if (this.left == null) {
                    this.left = new Node(number);
                } else {
                    this.left.insert(number);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(number);
                } else {
                    this.right.insert(number);
                }
            }
        }
    }
}
