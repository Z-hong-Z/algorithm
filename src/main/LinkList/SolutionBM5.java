import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionBM5 {
    public static void main(String[] args) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(Builder.builder(new int[]{1, 2, 3, 4}));
        listNodes.add(Builder.builder(new int[]{2, 3, 4, 5}));
        listNodes.add(Builder.builder(new int[]{7, 8, 9, 10}));
        listNodes.add(Builder.builder(new int[]{11, 12, 13, 15}));
        ListNode listNode = map(listNodes, 0, listNodes.size() - 1);
        Builder.traList(listNode);

    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            head = merge(head, lists.get(i));
        }
        return head;
    }

    public static ListNode map(ArrayList<ListNode> lists, int left, int right) {
        if (right - left + 1 == 1) {
            return lists.get(left);
        }
        if (right - left + 1 == 2) {
            return merge(lists.get(left), lists.get(right));
        }
        int middle = (left + right) / 2;
        ListNode leftHead = map(lists, left, middle);
        ListNode rightHead = map(lists, middle + 1, right);
        return merge(leftHead, rightHead);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            if (list1 == null && list2 == null) {
                return null;
            }
            return list1 == null ? list2 : list1;
        }
        ListNode head = list1.val > list2.val ? list2 : list1;
        ListNode next;
        if (head == list1) {
            next = merge(list1.next, list2);
        } else {
            next = merge(list1, list2.next);
        }
        head.next = next;
        return head;
    }


}
