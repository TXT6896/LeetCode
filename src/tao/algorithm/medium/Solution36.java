package tao.algorithm.medium;

import java.util.ArrayList;

/**
 * @description：回文链表
 * @author： tao
 * @create： 2024/11/22 14:57
 */
public class Solution36 {

    // ps: 三种方法：
    // 1.链表放到数组，两端比较是否相等  空间复杂度O(n)
    // 2.翻转链表，比较两个链表相等 空间复杂度O(n)
    // 3.翻转链表后半部分，比较是否一样 空间复杂度O(1); 这种方式单纯面向做题，真实场景可能需要考虑链表结构被改变之类的

    public boolean isPalindrome(ListNode head) {
        //链表放到数组
        ArrayList<Integer> array = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            array.add(curr.val);
            curr = curr.next;
        }
        //从两端分别比较是否相等
        int size = array.size();
        for (int i = 0; i < size / 2; i++) {
            if (!array.get(i).equals(array.get(size - 1 - i))) return false;
        }
        return true;
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
