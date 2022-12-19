package tao.medium;

/**
 * 删除链表倒数第n个节点，返回头节点
 *
 */
public class Solution7 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        /**
         * 双指针解法
         */
        ListNode pre = head;
        ListNode curr = head;
        while (n > 0) {
            curr = curr.next;
            n--;
        }
        //删除的是头节点
        if (curr == null) return pre.next;
        while (curr.next != null) {
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
        /**
         * 原始解法
         */
        /*ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        temp = head;
        if (count == n) return head.next;
        count = count - n;
        while (count > 0) {
            pre = pre.next;
            temp = temp.next;
            count--;
        }
        //删除
        pre.next = temp.next;

        return head;*/
    }

    static class ListNode {
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