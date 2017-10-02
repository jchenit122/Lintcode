package com.example.二叉树;

/**
 * Created by chenj240 on 8/10/17.
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 */

public class SubtreeWithMaximumAverage {

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


        Solution solution = new SubtreeWithMaximumAverage().new Solution();
        Solution solutionOne = new SubtreeWithMaximumAverage().new Solution();
        Solution solutionTwo = new SubtreeWithMaximumAverage().new Solution();
        Solution solutionThree = new SubtreeWithMaximumAverage().new Solution();

        System.out.println(solution.findSubtree2(root).val);
        System.out.println(solutionOne.findSubtree2(root1).val);
        System.out.println(solutionTwo.findSubtree2(root2).val);
        System.out.println(solutionThree.findSubtree2(root3).val);
    }

    public class Solution {

        private TreeNode returnedNode = null;
        private double maxAverage = Integer.MIN_VALUE;

        /**
         * @param root the root of binary tree
         *
         * @return the root of the maximum average of subtree
         */
        public TreeNode findSubtree2(TreeNode root) {
            // Write your code here

            helper(root);
            return returnedNode;
        }

        private ResultType helper(TreeNode root) {
            // exit
            if (root == null) {
                return new ResultType(0, 0);
            }

            if (root.left == null && root.right == null) {
                if (root.val > maxAverage){
                    returnedNode = root;
                }
                return new ResultType(root.val, 1);
            }

            // divider and conquer
            ResultType leftResult = helper(root.left);
            ResultType rightResult = helper(root.right);

            if (leftResult.sum * 1.0 / leftResult.nodeCount > maxAverage) {
                maxAverage = leftResult.sum * 1.0 / leftResult.nodeCount;
                returnedNode = root.left;
            }

            if (rightResult.sum * 1.0 / rightResult.nodeCount > maxAverage) {
                maxAverage = rightResult.sum * 1.0 / rightResult.nodeCount;
                returnedNode = root.right;
            }

            if ((leftResult.sum + rightResult.sum + root.val) * 1.0 / (leftResult.nodeCount + rightResult.nodeCount + 1) > maxAverage) {
                maxAverage = (leftResult.sum + rightResult.sum + root.val) * 1.0 / (leftResult.nodeCount + rightResult.nodeCount + 1);
                returnedNode = root;
            }


            return new ResultType(leftResult.sum + rightResult.sum + root.val, leftResult.nodeCount + rightResult.nodeCount+1);
        }
    }

    class ResultType {
        double sum;
        int nodeCount;

        public ResultType(double sum, int nodeCount) {
            this.sum = sum;
            this.nodeCount = nodeCount;
        }
    }
}
