package 树;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CreateBinaryTree {
    private static Scanner sc = new Scanner(System.in);
    public static Node create() {
        int val = sc.nextInt();
        if (val == -1) {
            return null;
        }
        Node root = new Node();
        root.val = val;
        root.left = create();
        root.right = create();
        return root;
    }


    public static Node create(int[] array) {
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i : array) {
            Node node = new Node();
            node.val = i;
            nodeList.add(node);
        }

        for (int i = 0; i < nodeList.size() / 2; i++) {
            Node tmp = nodeList.get(i);
            tmp.left = nodeList.get(2 * i + 1);
            if ( 2 * i + 2 < nodeList.size()){
                tmp.right = nodeList.get(2 * i + 2);
            }
        }
        return nodeList.get(0);
    }


    public static void midOrder(Node root){
        if (root == null){
            return;
        }

        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }

}
