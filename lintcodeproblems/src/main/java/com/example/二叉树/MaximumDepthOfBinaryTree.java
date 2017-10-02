package com.example.二叉树;

/**
 * Created by chenj240 on 8/12/17.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthOfBinaryTree {
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


        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        Solution solutionOne = new MaximumDepthOfBinaryTree().new Solution();
        Solution solutionTwo = new MaximumDepthOfBinaryTree().new Solution();
        Solution solutionThree = new MaximumDepthOfBinaryTree().new Solution();

        System.out.println(solution.maxDepth(root));
        System.out.println(solutionOne.maxDepth(root1));
        System.out.println(solutionTwo.maxDepth(root2));
        System.out.println(solutionThree.maxDepth(root3));
    }

    public class Solution {
        /**
         * @param root: The root of binary tree.
         *
         * @return: An integer.
         */
        public int maxDepth(TreeNode root) {
            // write your code here
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }

            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
}

