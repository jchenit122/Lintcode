package com.example.BFS;

import com.example.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenj240 on 8/17/17.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */

public class BinaryTreeLevelOrderTraversal {

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

        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        Solution solutionOne = new BinaryTreeLevelOrderTraversal().new Solution();

        System.out.println(solution.levelOrder(root));
        System.out.println(solutionOne.levelOrder(root1));


    }

    public class Solution {
        /**
         * @param root: The root of binary tree.
         *
         * @return: Level order a list of lists of integer
         */
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
            // write your code here
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            if (root == null) {
                return results;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                results.add(level);
            }
            return results;
        }
    }
}
