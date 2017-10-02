package com.example.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenj240 on 8/11/17.
 * Given a binary tree, return all root-to-leaf paths.
 */

public class BinaryTreePaths {
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


        Solution solution = new BinaryTreePaths().new Solution();
        Solution solutionOne = new BinaryTreePaths().new Solution();
        Solution solutionTwo = new BinaryTreePaths().new Solution();
        Solution solutionThree = new BinaryTreePaths().new Solution();

        System.out.println(solution.binaryTreePaths(root));
        System.out.println(solutionOne.binaryTreePaths(root1));
        System.out.println(solutionTwo.binaryTreePaths(root2));
        System.out.println(solutionThree.binaryTreePaths(root3));
    }

    public class Solution {
        /**
         * @param root the root of the binary tree
         *
         * @return all root-to-leaf paths
         */
        public List<String> binaryTreePaths(TreeNode root) {
            // Write your code here
            return helper(root);
        }
        private List<String> helper(TreeNode root) {

            List<String> results = new ArrayList<>();
            // exit
            if (root == null) {
                return results;
            }

            if (root.left == null && root.right == null) {
                results.add(root.val + "");
                return results;
            }


            // divide and conquer

            List<String> left = helper(root.left);
            List<String> right = helper(root.right);

            for (String eachString : left) {
                results.add(root.val + "->" + eachString);
            }

            for (String eachString : right) {
                results.add(root.val + "->" + eachString);
            }

            return results;
        }
    }

}
