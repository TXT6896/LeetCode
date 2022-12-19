package tao.easy;

/**
 * 环形链表
 */
public class Solution7 {

    public boolean hasCycle(ListNode head) {
        ListNode i1 = new ListNode(1);
        i1.next = head;
        ListNode i2 = new ListNode(2);
        i2.next = head;
        while (i2.next != null && i2.next.next != null) {
            i2 = i2.next.next;
            if (i1 == i2) break;
            i1 = i1.next;
        }
        return i1 == i2;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
