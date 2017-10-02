package high.frequent;

import com.example.二叉树.TreeNode;

/**
 * Created by chenj240 on 9/20/17.
 * Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.
 * Notice
 * LintCode will print the subtree which root is your return node.
 * It's guaranteed that there is only one subtree with maximum sum and the given binary tree is not an empty tree.
 * Example
 * Given a binary tree:
 * 1
 * /   \
 * -5     2
 * / \    /  \
 * 0   3  -4  -5
 * return the node with value 3.
 */

public class MaximumSubtree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);


        Solution solution = new MaximumSubtree().new Solution();


        System.out.println(solution.findSubtree(root).val);
    }

    public class Solution {
        int maxValue = Integer.MIN_VALUE;
        TreeNode returnNode;

        /*
         * @param root: the root of binary tree
         * @return: the maximum weight node
         */
        public TreeNode findSubtree(TreeNode root) {
            // write your code here
            helper(root);
            return returnNode;
        }

        private int helper(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            int leftValue = helper(treeNode.left);
            int rightValue = helper(treeNode.right);
            int result = leftValue + rightValue + treeNode.val;

            if (result > maxValue) {
                maxValue = result;
                returnNode = treeNode;
            }
            return result;
        }
    }
}
