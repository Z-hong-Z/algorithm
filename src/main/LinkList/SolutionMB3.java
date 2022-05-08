import org.junit.Test;

public class SolutionMB3 {
    /**
     *
     * @param head ListNode类
     */
    public ListNode sortInList (ListNode head) {
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur;
            ListNode min =  new ListNode(Integer.MAX_VALUE);
            min.val = Integer.MAX_VALUE;
            while(tmp != null){
                if(tmp.val < min.val){
                    min = tmp;
                }
                tmp = tmp.next;

            }
            int t = min.val;
            min.val = cur.val;
            cur.val = t;
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void Demo(){
        ListNode head = Builder.builder(new int[]{5, 4, 3, 2, 1});
        sortInList(head);
        Builder.traList(head);
    }
}
