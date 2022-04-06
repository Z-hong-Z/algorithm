package 树;

import java.util.LinkedList;

public class Demo02 {
    public static void main(String[] args) {
        //TODO 判断树是否为完全二叉树
        Node root = CreateBinaryTree.create();
        System.out.println(check(root));

    }

    public static boolean check(Node root) {
        if (root == null) return false;

        int flag = 0;
        LinkedList<Node> rootQueue = new LinkedList<>();
        LinkedList<Node> leftQueue = new LinkedList<>();
        rootQueue.addLast(root);
        while (rootQueue.size() != 0) {
            Node node = rootQueue.removeFirst();
            if (node.right != null && root.left == null) {
                return false;
            }
            if (node.left != null && node.right == null) {
                flag = 1;
                leftQueue.addLast(node.left);
                continue;
            }
            if (flag == 1){
                if (node.left != null || node.right != null) return false;
            }
            if (node.left != null){
                leftQueue.addLast(node.left);
            }
            if (node.right != null){
                leftQueue.addLast(node.right);
            }
            if (rootQueue.size() == 0){
                while (leftQueue.size()!=0){
                    rootQueue.addLast(leftQueue.removeFirst());
                }
            }
        }
        return true;
    }
}
