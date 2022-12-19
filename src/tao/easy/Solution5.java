package tao.easy;

/**
 * 合并两个有序链表
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        ListNode listNode1 = new ListNode(1);
        // ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode4;
        // listNode2.next = listNode4;

        ListNode listNode5 = new ListNode(1);
        // ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);
        listNode5.next = listNode7;
        //  listNode6.next = listNode7;

        solution5.mergeTwoLists(listNode1, listNode5);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode res = list1.val <= list2.val ? list1 : list2;
        ListNode curr = new ListNode();
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
                continue;
            }
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return res;
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
