package tao.algorithm.medium;

/**
 * @description：82 删除排序链表中的重复元素 II
 * @author： tao
 * @create： 2025/1/23 16:21
 */
public class Solution39 {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = createLinkedList(values);
        printLinkedList(head);
        ListNode listNode = deleteDuplicates(head);
        printLinkedList(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        //前置节点
        ListNode temp = new ListNode(0, head);
        ListNode curr = temp;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        //1 ->2 ->3 ->3 ->4 ->4 ->5 ->null

        return temp.next;
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

    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null; // 返回null，如果输入数组为空
        }

        ListNode head = new ListNode(values[0]); // 创建头节点
        ListNode current = head; // 当前节点指向头节点

        // 遍历数组，创建节点并连接
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]); // 创建新节点并连接
            current = current.next; // 移动到当前节点
        }

        return head; // 返回链表的头节点
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null"); // 结束链表表示
    }
}
