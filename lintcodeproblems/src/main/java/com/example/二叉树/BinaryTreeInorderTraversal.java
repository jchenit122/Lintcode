package com.example.二叉树;

import java.util.ArrayList;

/**
 * Created by chenj240 on 8/12/17.
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

public class BinaryTreeInorderTraversal {


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


        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        Solution solutionOne = new BinaryTreeInorderTraversal().new Solution();
        Solution solutionTwo = new BinaryTreeInorderTraversal().new Solution();
        Solution solutionThree = new BinaryTreeInorderTraversal().new Solution();

        System.out.println(solution.inorderTraversal(root));
        System.out.println(solutionOne.inorderTraversal(root1));
        System.out.println(solutionTwo.inorderTraversal(root2));
        System.out.println(solutionThree.inorderTraversal(root3));
    }

    public class Solution {
        /**
         * @param root: The root of binary tree.
         *
         * @return: Inorder in ArrayList which contains node values.
         */
        public ArrayList<Integer> inorderTraversal(TreeNode root) {
            // write your code here
            ArrayList<Integer> results = new ArrayList<>();
            helper(root, results);
            return results;
        }

        private void helper(TreeNode root, ArrayList<Integer> results) {
            if (root == null){
                return;
            }
            helper(root.left, results);
            results.add(root.val);
            helper(root.right, results);
        }
    }

//    //Version 2: Divide & Conquer
//    public class Solution {
//        public ArrayList<Integer> preorderTraversal(TreeNode root) {
//            ArrayList<Integer> result = new ArrayList<Integer>();
//            // null or leaf
//            if (root == null) {
//                return result;
//            }
//
//            // Divide
//            ArrayList<Integer> left = preorderTraversal(root.left);
//            ArrayList<Integer> right = preorderTraversal(root.right);
//
//            // Conquer
//            result.add(root.val);
//            result.addAll(left);
//            result.addAll(right);
//            return result;
//        }
//    }

//
//    Version 0: Non-Recursion (Recommend)
//    public class Solution {
//        public List<Integer> preorderTraversal(TreeNode root) {
//            Stack<TreeNode> stack = new Stack<TreeNode>();
//            List<Integer> preorder = new ArrayList<Integer>();
//
//            if (root == null) {
//                return preorder;
//            }
//
//            stack.push(root);
//            while (!stack.empty()) {
//                TreeNode node = stack.pop();
//                preorder.add(node.val);
//                if (node.right != null) {
//                    stack.push(node.right);
//                }
//                if (node.left != null) {
//                    stack.push(node.left);
//                }
//            }
//
//            return preorder;
//        }
//    }

}
