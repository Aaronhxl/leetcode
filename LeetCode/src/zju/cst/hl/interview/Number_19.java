package zju.cst.hl.interview;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Number_19 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        if(head == null){
            return result;
        }
        ListNode node = head;
        int count = 0;
        while (node != null){
            node = node.next;
            count++;
        }
        int deleteIndex = count - n;
        if(deleteIndex == 0){ //删除第一个元素
            return result.next;
        }
        ListNode pre = head;
        ListNode now = head;
        while (deleteIndex > 0){
            pre = now;
            now = now.next;
            deleteIndex--;
        }
        pre.next = now.next;
        return result;

    }

    /**
     * 分析：删除倒数第n个节点，不妨看作删除顺数多少个节点
     */
}
