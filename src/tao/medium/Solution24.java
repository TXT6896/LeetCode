package tao.medium;

/**
 * 二叉树展开为链表
 */
public class Solution24 {

    private TreeNode temp = null;


/*    public void flatten(TreeNode root, TreeNode last) {
        if (root == null) {
            return;
        }
        flatten(root.left, root);
        flatten(root.right, root);
        temp.left = last.right;
    }*/

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        root.right = temp;
        temp = root;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
