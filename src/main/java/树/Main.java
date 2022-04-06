package 树;

public class Main {
    public static void main(String[] args) {
        Node root = CreateBinaryTree.create();
        CreateBinaryTree.midOrder(root);
    }
}
