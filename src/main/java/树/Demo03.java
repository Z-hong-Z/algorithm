package 树;

import java.util.Deque;
import java.util.LinkedList;

public class Demo03 {
    public static void main(String[] args) {
        // TODO 判断是否为满二叉树
        Node root = CreateBinaryTree.create();
        System.out.println(check(root));

    }

    public static boolean check(Node root) {
        if (root == null) return false;
        int lenth = 1;
        Deque<Node> rootQueue = new LinkedList<>();
        Deque<Node> leftQueue = new LinkedList<>();
        rootQueue.addLast(root);
        while (rootQueue.size() != 0) {
            Node node = rootQueue.removeFirst();
            if (node.left != null){
                leftQueue.addLast(node.left);
            }
            if (node.right != null){
                leftQueue.addLast(node.right);
            }

            if (rootQueue.size() == 0) {
                if (leftQueue.size() != 0 && leftQueue.size() != lenth * 2) {
                    return false;
                }
                lenth = lenth * 2;
                while (leftQueue.size() != 0) {
                    rootQueue.addLast(leftQueue.removeFirst());
                }
            }
        }
        return true;
    }
}
