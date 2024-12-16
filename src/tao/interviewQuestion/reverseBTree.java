package tao.interviewQuestion;

/**
 * 反转二叉树
 */
public class reverseBTree {

    public static void reversehead(Node pre) {
        if (pre == null) return;

        reverse(pre, pre.left);
        reverse(pre, pre.right);
        Node temp = pre.left;
        pre.left = pre.right;
        pre.right = temp;
    }
    public static void reverse(Node pre, Node node) {
        if (node == null) return;
        //叶子节点
        if (node.left == null && node.right == null) {
            Node temp = pre.left;
            pre.left = pre.right;
            pre.right = temp;
            return;
        }
        //递归所有节点
        reverse(node, node.left);
        reverse(node, node.right);
        Node temp = pre.left;
        pre.left = pre.right;
        pre.right = temp;

    }

    /**
     * 实际最简单解法
     * @param node
     */
    public static void reverseFinal(Node node) {

        if (node == null) {
            return;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        //递归所有节点
        reverseFinal(node.left);
        reverseFinal(node.right);

    }



    static class Node {

        public Node left;
        public Node right;
        public int value;


    }
}
