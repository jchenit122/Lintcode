package com.example.二叉树;

/**
 * Created by chenj240 on 8/12/17.
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 */

public class FlattenBinaryTreeToLinkedList {

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


        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        Solution solutionOne = new FlattenBinaryTreeToLinkedList().new Solution();
        Solution solutionTwo = new FlattenBinaryTreeToLinkedList().new Solution();
        Solution solutionThree = new FlattenBinaryTreeToLinkedList().new Solution();

        solution.flatten(root);
        solutionOne.flatten(root1);
        solutionTwo.flatten(root2);
        solutionThree.flatten(root3);

        BinaryTreePaths.Solution solutionPath = new BinaryTreePaths().new Solution();
        BinaryTreePaths.Solution solutionOnePath = new BinaryTreePaths().new Solution();
        BinaryTreePaths.Solution solutionTwoPath = new BinaryTreePaths().new Solution();
        BinaryTreePaths.Solution solutionThreePath = new BinaryTreePaths().new Solution();

        System.out.println(solutionPath.binaryTreePaths(root));
        System.out.println(solutionOnePath.binaryTreePaths(root1));
        System.out.println(solutionTwoPath.binaryTreePaths(root2));
        System.out.println(solutionThreePath.binaryTreePaths(root3));
    }

    public class Solution {

        // traverse

        /**
         * @param root: a TreeNode, the root of the binary tree
         *
         * @return nothing
         */
        public void flatten(TreeNode root) {
            // write your code here
            helper(root);
        }

        private TreeNode helper(TreeNode root) {
            //exit

            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null) {
                return root;
            }

            //divide and conquer
            TreeNode left = helper(root.left);
            TreeNode right = helper(root.right);
            if (left != null) {
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            if (right != null) {
                return right;
            }
            return left;
        }
    }
}
