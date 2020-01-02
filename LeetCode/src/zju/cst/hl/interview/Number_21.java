package zju.cst.hl.interview;

/**
 *  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Number_21 {

    public static void main(String[] args) {

    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode(0);
        ListNode tail = result;
        ListNode now = null;
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                now = head1;
                head1 = head1.next;
            }else {
                now = head2;
                head2 = head2.next;
            }
            tail.next = now;
            tail = now;
        }

        if(head1 == null){
            tail.next = head2;
        }
        if(head2 == null){
            tail.next = head1;
        }
        return result.next;
    }

    /**
     *  有序链表的合并
     */
}



