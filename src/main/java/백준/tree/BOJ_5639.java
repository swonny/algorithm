package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {

    static class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (this.left == null) this.left = new Node(value);
                else this.left.insert(value);
            } else if (value > this.value) {
                if (this.right == null) this.right = new Node(value);
                else this.right.insert(value);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int rootValue = Integer.parseInt(br.readLine());
        final Node root = new Node(rootValue);

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            root.insert(Integer.parseInt(input));
        }

        postorder(root);
    }

    public static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }
}
