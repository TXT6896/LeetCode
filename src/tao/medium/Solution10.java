package tao.medium;

/**
 * 两两交换链表中的节点
 */
public class Solution10 {

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pre = new ListNode(0, head);
        ListNode curr = head;
        head = head.next;
        while (null != curr && null != curr.next) {
            pre.next = curr.next;
            curr.next = curr.next.next;
            pre.next.next = curr;

            pre = pre.next.next;
            curr = pre.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
