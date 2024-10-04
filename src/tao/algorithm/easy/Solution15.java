package tao.algorithm.easy;

/**
 * 对称二叉树
 */
public class Solution15 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (!(left != null && right != null)) return false;
        if (left.val != right.val) return false;
        boolean flag = isSymmetric(left.left, right.right);
        boolean b = isSymmetric(left.right, right.left);
        return flag && b;
    }


    public class TreeNode {
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
