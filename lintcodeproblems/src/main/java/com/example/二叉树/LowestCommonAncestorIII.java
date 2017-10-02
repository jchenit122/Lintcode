package com.example.二叉树;

/**
 * Created by chenj240 on 8/12/17.
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 */

public class LowestCommonAncestorIII {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);

        TreeNode unExist = new TreeNode(0);

        Solution solution = new LowestCommonAncestorIII().new Solution();

        System.out.println(solution.lowestCommonAncestor3(root, root.left.right, root.right.right).val);
        System.out.println(solution.lowestCommonAncestor3(root, root.left.right, root.left).val);
        System.out.println(solution.lowestCommonAncestor3(root, root.left.right, root.left.right).val);
        TreeNode treeNode = solution.lowestCommonAncestor3(root, root, unExist);
        System.out.println(treeNode != null ? treeNode.val : "null");

    }

    public class Solution {
        /**
         * @param root The root of the binary tree.
         * @param A    and B two nodes
         *
         * @return: Return the LCA of the two nodes.
         */
        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
            // write your code here

            if (notFound(root, B) || notFound(root, A)) {
                return null;
            } else {
                return helper(root, A, B);
            }
        }

        private boolean notFound(TreeNode root, TreeNode noteToSearch) {
            if (root != null) {
                if (root.val == noteToSearch.val) {
                    return false;
                } else {
                    return notFound(root.left, noteToSearch) && notFound(root.right, noteToSearch);
                }
            }
            return true;
        }

        private TreeNode helper(TreeNode root, TreeNode A, TreeNode B) {
            if (root == A || root == B || root == null) {
                return root;
            }
            TreeNode left = helper(root.left, A, B);
            TreeNode right = helper(root.right, A, B);

            if ((left == A && right == B) || (left == B && right == A)) {
                return root;
            }

            if (left != null) {
                return left;
            }

            if (right != null) {
                return right;
            }

            return null;
        }
    }
}
