package com.example.GoogleInterviews;

import com.example.二叉树.TreeNode;

/**
 * Created by chenj240 on 9/5/17.
 * <p>
 * You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 * <p>
 * Notice
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */

public class Subtree {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left = two;
        one.right = three;
        three.left = four;

        TreeNode threeOne = new TreeNode(3);
        threeOne.left = new TreeNode(4);

        TreeNode threeTwo = new TreeNode(3);
        threeTwo.right = new TreeNode(4);

        Solution solution = new Subtree().new Solution();
        System.out.println(solution.isSubtree(one, threeOne));
        System.out.print(solution.isSubtree(one, threeTwo));

    }

    public class Solution {
        /*
         * @param T1: The roots of binary tree T1.
         * @param T2: The roots of binary tree T2.
         * @return: True if T2 is a subtree of T1, or false.
         */
        public boolean isSubtree(TreeNode T1, TreeNode T2) {
            // write your code here
            if (T1 == null) {
                return false;
            }
            if (T2 == null) {
                return true;
            }

            if (isSame(T1, T2)) {
                return true;
            }

            if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
                return true;
            }
            return false;
        }

        private boolean isSame(TreeNode t1, TreeNode t2) {
            if (t1 == null || t2 == null) {
                return t1 == t2;
            }
            if (t1.val == t2.val) {
                return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
            }
            return false;
        }
    }
}
