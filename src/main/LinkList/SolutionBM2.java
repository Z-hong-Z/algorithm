import org.junit.Before;
import org.junit.Test;

public class SolutionBM2 {
    int[] arr = {1, 2, 3, 4, 5};
    int m = 1;
    int n = 3;
    ListNode ret = null;
    ListNode root = null;
    @Before
    public void initListNode(){
        root = Builder.builder(arr);

    }

    @Test
    public void reverseBetween() {
        ListNode cur = root;
        ListNode pro = null; //反转前的最后一个

        for (int i = 1; i < m; i++) {
            pro = cur;
            cur = cur.next;
        }

        //从cur开始反转
        ListNode pHead = cur;

        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pHead;
            pHead = next;

        }
        if (pro != null) {
            pro.next = pHead;
            Builder.traList(root);
        } else {
            Builder.traList(pHead);
        }

    }
}
