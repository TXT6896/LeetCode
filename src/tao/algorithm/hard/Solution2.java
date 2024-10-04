package tao.algorithm.hard;

import java.util.Arrays;

/**
 * 合并K个升序链表
 */
public class Solution2 {
    public static void main(String[] args) {
        String s = "085b33fb2d62beae5b7f87f16d1877de:股票自主交易1组;20817460e0f77a2b8449774d0b3625d0:股票自主交易2组;";
        String ss = "085b33fb2d62beae5b7f87f16d1877de";
        String substring = s.substring(s.indexOf(ss) + "085b33fb2d62beae5b7f87f16d1877de".length() + 1);
        System.out.println(substring);
        System.out.println(substring.substring(0, substring.indexOf(";")));

        String s1 = "skjhdf偶s";
        System.out.println(s1.substring(0, s1.length()));


    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        if (lists.length < 1) return null;
        int index = lists.length / 2;
        // ListNode[] listLeft = new ListNode[index];
        ListNode[] listLeft = Arrays.copyOf(lists, index);
        /*for (int i = 0; i < listLeft.length; i++) {
            listLeft[i] = lists[i];
        }*/
        //ListNode[] listRight = new ListNode[lists.length - index];
        ListNode[] listRight = Arrays.copyOfRange(lists, index, lists.length);
/*        for (int i = 0; i < listRight.length; i++) {
            listRight[i] = lists[index++];
        }*/
        ListNode leftNode = mergeKLists(listLeft);
        ListNode rightNode = mergeKLists(listRight);

        return mergeTwoLists(leftNode, rightNode);
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
