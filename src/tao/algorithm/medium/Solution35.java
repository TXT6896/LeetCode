package tao.algorithm.medium;

/**
 * @description：二叉树的最近公共祖先
 * @author： tao
 * @create： 2024/11/22 10:45
 */
public class Solution35 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //先判断根节点是否为p或q (ps: 这一步很关键，子树如果没有p或q，最终一定会返回null)
        if (root == null || root == p || root == q) return root;
        //不是则分别查左右两棵子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左右两边都没找到，返回null (ps: 这一步可以省略，但是写出来易于理解)
        if (left == null && right == null) return null;
        //左边啥也没有，返回右边
        if (left == null) return right;
        //右边啥也没有，返回左边
        if (right == null) return left;

        //左右都有值，那就root节点是最近的祖先
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

