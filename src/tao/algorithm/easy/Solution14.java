package tao.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class Solution14 {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        trace(root);
        return result;
    }

    public void trace(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            trace(root.left);

        }

        result.add(root.val);

        if (root.right != null) {
            trace(root.right);
        }

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
