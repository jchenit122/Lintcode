package com.example.二叉树;

/**
 * Created by chenj240 on 8/11/17.
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 */

public class MinimumSubtree {

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


        Solution solution = new MinimumSubtree().new Solution();
        Solution solutionOne = new MinimumSubtree().new Solution();
        Solution solutionTwo = new MinimumSubtree().new Solution();
        Solution solutionThree = new MinimumSubtree().new Solution();

        System.out.println(solution.findSubtree(root).val);
        System.out.println(solutionOne.findSubtree(root1).val);
        System.out.println(solutionTwo.findSubtree(root2).val);
        System.out.println(solutionThree.findSubtree(root3).val);
    }

    public class Solution {

        private int minimumSum = Integer.MAX_VALUE;
        private TreeNode returnedNode = null;

        /**
         * @param root the root of binary tree
         *
         * @return the root of the minimum subtree
         */
        public TreeNode findSubtree(TreeNode root) {
            // Write your code here
            helper(root);
            return returnedNode;
        }

        private int helper(TreeNode root) {
            // exit
            if (root == null) {
                return 0;
            }

            // divide and conquer
            int leftResult = helper(root.left);
            int rightResult = helper(root.right);
            int result = leftResult + rightResult + root.val;

            if (result < minimumSum) {
                minimumSum = result;
                returnedNode = root;
            }

            return result;

        }
    }
}
