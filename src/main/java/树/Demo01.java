package 树;



public class Demo01 {
    //TODO 判断是否为二叉搜索树
    public static void main(String[] args) {
        int[] ints = {5, 3, 6, 1, 4, 1, 7};
        System.out.println(checkBST(CreateBinaryTree.create(ints)));
    }


    public static int proVal = Integer.MIN_VALUE;

    public static boolean checkBST(Node root) {
        if (root == null) return true;

        boolean left = checkBST(root.left);

        if (!left) {
            return false;
        }
        if (root.val <= proVal) {
            return false;
        } else {
            proVal = root.val;
        }


        return checkBST(root.right);
    }

}
