package tao.algorithm.medium;

import java.util.ArrayList;

/**
 * 环形链表 II
 */
public class Solution28 {

    public ListNode detectCycle(ListNode head) {

        // 自己写的，判断环存在与否根本不重要
/*        boolean b = isCycle(head);
        //无环
        if (!b) return null;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;
        listNodes.add(head);
        while (true) {
            temp = temp.next;
            if (listNodes.contains(temp)) return temp;
            listNodes.add(temp);
        }*/

        //大道至简
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode temp = new ListNode(1);
        temp.next = head;
        while (temp.next != null) {
            if (listNodes.contains(temp)) return temp;
            listNodes.add(temp);
            temp = temp.next;
        }
        return null;
    }


    public boolean isCycle(ListNode head) {
        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(1);
        i1.next = head;
        i2.next = head;

        while (i1 != null && i2 != null && i2.next != null) {
            if (i1 == i2) return true;
            i1 = i1.next;
            i2 = i2.next.next;
        }
        return false;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
