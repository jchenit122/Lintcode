package com.example.二叉树;

import java.util.ArrayList;

/**
 * Created by chenj240 on 8/12/17.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 */

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        Solution solution = new ValidateBinarySearchTree().new Solution();
        Solution solutionOne = new ValidateBinarySearchTree().new Solution();

        System.out.println(solution.isValidBST(root));
        System.out.println(solutionOne.isValidBST(root1));


    }

    public class Solution {
        /**
         * @param root: The root of binary tree.
         *
         * @return: True if the binary tree is BST, or false
         */
        public boolean isValidBST(TreeNode root) {
            // write your code here
            ArrayList<Integer> result = new ArrayList<>();
            helper(root, result);
            for (int i = 0; i < result.size()-1; i++) {
                if (result.get(i) >= result.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        private void helper(TreeNode root, ArrayList result) {
            if (root == null) {
                return;
            }
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
}
