package tao.easy;

/**
 * 二叉树的最大深度
 */
public class Solution13 {

    private int dep = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return dep;
        maxDepth(root, 1);
        return dep;
    }

    public void maxDepth(TreeNode root, int curr) {
        if (root.left == null && root.right == null) {
            dep = Math.max(curr, dep);
        }
        if (root.left != null) maxDepth(root.left, curr + 1);
        if (root.right != null) maxDepth(root.right, curr + 1);
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

