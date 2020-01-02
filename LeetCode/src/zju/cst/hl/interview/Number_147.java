package zju.cst.hl.interview;

import java.awt.*;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class Number_147 {

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[4];
        nodes[3] = new ListNode(3);
        nodes[3].next = null;
        nodes[2] = new ListNode(1);
        nodes[2].next = nodes[3];
        nodes[1] = new ListNode(2);
        nodes[1].next = nodes[2];
        nodes[0] = new ListNode(4);
        nodes[0].next = nodes[1];
        ListNode listNode = insertionSortList(nodes[0]);
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head.next;
        ListNode later;
        ListNode answer = head;
        ListNode curPre = head;
        while (cur != null){
            later = cur.next;
            ListNode index = answer;
            pre = null;
            while (index != null){
                if(index == cur){
                    curPre = cur;
                    cur = later;
                    break;
                }
                if(index.val > cur.val){
                    if(pre == null){//头节点
                        cur.next = index;
                        curPre.next = later;
                        answer = cur;
                        cur = later;
                    }else { //非头节点
                        cur.next = index;
                        curPre.next = later;
                        pre.next = cur;
                        cur = later;
                    }
                    break;
                }
                pre = index;
                index = index.next;
            }
        }
        return answer;
    }

    /**
     * 分析：
     *      思路1：其实很简单，插入排序的时间复杂度本身就是O(n2)
     *      模拟它的过程就行，可以从头节点向下寻找适合的位置
     *      相比与数组就是它还不需要移动元素
     *      思路2：反其道而行，我们开始找到最大的元素，再逆序
     *
     *
     *      你需要关心哪些节点？
     *          你当前需要移动的节点，为了保证位置，还得需要记录其前后的节点，为了调整位置
     *          你需要插入的节点位置，为了保证位置，也需要记录插入位置的前后位置
     *          也就是说你需要关注6个节点
     */
}
