package com.example.二叉树;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by chenj240 on 8/12/17.
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by
 * more than 1.
 */

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(-1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(-4);
        root1.right.right = new TreeNode(-5);

        TreeNode root2 = new TreeNode(10);

        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(1);
        root3.left.left = new TreeNode(2);


        Solution solution = new BalancedBinaryTree().new Solution();
        Solution solutionOne = new BalancedBinaryTree().new Solution();
        Solution solutionTwo = new BalancedBinaryTree().new Solution();
        Solution solutionThree = new BalancedBinaryTree().new Solution();

        System.out.println(solution.isBalanced(root));
        System.out.println(solutionOne.isBalanced(root1));
        System.out.println(solutionTwo.isBalanced(root2));
        System.out.println(solutionThree.isBalanced(root3));
    }

    public class Solution {
        /**
         * @param root: The root of binary tree.
         *
         * @return: True if this Binary tree is Balanced, or false.
         */
        public boolean isBalanced(TreeNode root) {
            // write your code here
            return helper(root).isBalanced;
        }

        private ResultType helper(TreeNode root) {
            // exit
            if (root == null) {
                return new ResultType(true, 0);
            }

            // divide and conquer
            ResultType left = helper(root.left);
            ResultType right = helper(root.right);

            if (!left.isBalanced || !right.isBalanced) {
                return new ResultType(false, 0);
            }

            if (Math.abs(left.depth - right.depth) > 1) {
                return new ResultType(false, 0);
            }

            return new ResultType(true, Math.max(left.depth, right.depth) + 1);
        }

        class ResultType {
            boolean isBalanced;
            int depth;

            public ResultType(boolean isBalanced, int depth) {
                this.isBalanced = isBalanced;
                this.depth = depth;
            }
        }
    }

}
