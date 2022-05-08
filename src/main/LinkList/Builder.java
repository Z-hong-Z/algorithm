public class Builder {


    public static void traList(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }

    }

    public static ListNode builder(int[] arr) {
        ListNode root = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root = tailerInsert(root, arr[i]);
        }
        return root;
    }


    public static ListNode tailerInsert(ListNode root, int val) {
        ListNode cur = root;
        while (cur != null) {
            if (cur.next == null) {
                ListNode tmp = new ListNode();
                tmp.setVal(val);
                cur.next = tmp;
                break;
            }
            cur = cur.next;
        }
        return root;
    }

    public static ListNode headInsert(ListNode root, int val) {
        ListNode listNode = new ListNode();
        listNode.setVal(val);
        listNode.setNext(root);
        return listNode;
    }
}
