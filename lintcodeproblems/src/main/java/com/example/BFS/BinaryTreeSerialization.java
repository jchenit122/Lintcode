package com.example.BFS;

import com.example.二叉树.TreeNode;

import java.util.ArrayList;

/**
 * Created by chenj240 on 8/21/17.
 * Design an algorithm and write code to serialize and deserialize a binary tree.
 * Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 */

public class BinaryTreeSerialization {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);

        Solution solution = new BinaryTreeSerialization().new Solution();

        String output = solution.serialize(root);
        System.out.print(output);
        System.out.print(solution.deserialize(output).val);

    }

    class Solution {
        /**
         * This method will be invoked first, you should design your own algorithm
         * to serialize a binary tree which denote by a root node to a string which
         * can be easily deserialized by your own "deserialize" method later.
         */
        public String serialize(TreeNode root) {
            // write your code here
            if (root == null) {
                return "{}";
            }
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(root);
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if (node == null) {
                    continue;
                }
                list.add(node.left);
                list.add(node.right);
            }

            while (list.get(list.size() - 1) == null) {
                list.remove(list.size() - 1);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (TreeNode node : list) {
                if (node == null) {
                    sb.append("#,");
                } else {
                    sb.append(node.val + ",");
                }
            }
            sb.append("}");
            return sb.toString();
        }

        /**
         * This method will be invoked second, the argument data is what exactly
         * you serialized at method "serialize", that means the data is not given by
         * system, it's given by your own serialize method. So the format of data is
         * designed by yourself, and deserialize it here as you serialize it in
         * "serialize" method.
         */
        public TreeNode deserialize(String data) {
            // write your code here
            if (data.equals("{}")) {
                return null;
            }
            String[] values = data.substring(1, data.length() - 1).split(",");
            ArrayList<TreeNode> list = new ArrayList<>();
            TreeNode root = new TreeNode(Integer.valueOf(values[0]));
            list.add(root);

            boolean isLeftNode = true;
            int index = 0;
            for (int i = 1; i < values.length; i++) {
                if (!values[i].equals("#")) {
                    TreeNode node = new TreeNode(Integer.valueOf(values[i]));
                    list.add(node);
                    if (isLeftNode) {
                        list.get(index).left = node;
                    } else {
                        list.get(index).right = node;
                    }
                }

                if (!isLeftNode) {
                    index++;
                }

                isLeftNode = !isLeftNode;
            }

            return root;
        }
    }
}
