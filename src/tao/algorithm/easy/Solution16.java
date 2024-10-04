package tao.algorithm.easy;

/**
 * 相交链表
 *
 * @description：TODO
 * @author： tao
 * @create： 2023/12/5 16:19
 */
public class Solution16 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode headB = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        headB.next = node3;
        node3.next = node4;
        Solution16 so = new Solution16();
        so.getIntersectionNode(headA,headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        //先计算两个链表各自长度
        ListNode nodeA = headA;
        int countA = 0;
        while (nodeA != null) {
            countA++;
            nodeA = nodeA.next;
        }

        ListNode nodeB = headB;
        int countB = 0;
        while (nodeB != null) {
            countB++;
            nodeB = nodeB.next;
        }

        //谁长谁先走几步
        if (countA > countB) {
            int steps = countA - countB;
            for (int i = 0; i < steps; i++) {
                headA = headA.next;
            }
        } else {
            int steps = countB - countA;
            for (int i = 0; i < steps; i++) {
                headB = headB.next;
            }
        }
        //大家一起走，没遇见就是没香蕉
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
