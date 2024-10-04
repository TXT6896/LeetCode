package tao.algorithm.medium;

import java.time.Instant;
import java.time.ZoneOffset;

/**
 * @description：排序链表
 * @author： tao
 * @create： 2023/11/23 11:12
 */
public class Solution32 {

    public static void main(String[] args) {
/*        ListNode node1 = new ListNode();
        node1.val = 4;
        ListNode node2 = new ListNode();
        node2.val = 1;
        ListNode node3 = new ListNode();
        node3.val = 2;
        ListNode node4 = new ListNode();
        node4.val = 3;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution32 so = new Solution32();
        ListNode listNode = so.sortList(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(123);*/

        System.out.println(Instant.ofEpochMilli(0).atZone(ZoneOffset.ofHours(8)).toLocalDate());
/*        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects.stream().count());*/
    }

    /**
     * 我的
     * 暴力排序，超时，时间复杂度 O(n^2)
     *
     * @param head
     * @return
     */
    /*public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode newHead = head;
        ListNode temp = head.next;
        newHead.next = null;
        while (temp != null) {
            ListNode target = temp;
            temp = temp.next;
            target.next = null;
            newHead = sortList(newHead, target);
        }
        return newHead;
    }

    public ListNode sortList(ListNode head, ListNode target) {
        if (target == null) return head;
        if (target.val <= head.val) {
            target.next = head;
            return target;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (target.val <= pre.next.val) {
                ListNode next = pre.next;
                pre.next = target;
                target.next = next;
                return head;
            }
            pre = pre.next;
        }
        pre.next = target;
        return head;
    }*/


// 归并排序
    private ListNode mergeSort(ListNode head) {
        // 如果没有结点/只有一个结点，无需排序，直接返回
        if (head == null || head.next == null) return head;
        // 快慢指针找出中位点
        ListNode slowp = head, fastp = head.next.next, l, r;
        while (fastp != null && fastp.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        // 对右半部分进行归并排序
        r = mergeSort(slowp.next);
        // 链表判断结束的标志：末尾节点.next==null
        slowp.next = null;
        // 对左半部分进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    // 合并链表
    private ListNode mergeList(ListNode l, ListNode r) {
        // 临时头节点
        ListNode tmpHead = new ListNode(-1);
        ListNode p = tmpHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return tmpHead.next;
    }


    public static class ListNode {
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
