package com.example.heap_hash;

import com.example.BFS.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenj240 on 9/7/17.
 * Merge k sorted linked lists and return it as one sorted list.
 * <p>
 * Analyze and describe its complexity.
 * Example
 * Given lists:
 * [
 * 2->4->null,
 * null,
 * -1->null
 * ],
 * return -1->2->4->null.
 */

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(-1);

        one.next = two;
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(one);
        listNodes.add(null);
        listNodes.add(three);

        Solution solution = new MergeKSortedLists().new Solution();

        ListNode head = solution.mergeKLists(listNodes);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public class Solution {
        /**
         * @param lists: a list of ListNode
         *
         * @return: The head of one sorted list.
         */
        public ListNode mergeKLists(List<ListNode> lists) {
            // write your code here
            if (lists == null || lists.size() == 0) {
                return null;
            }

            if (lists.size() == 1) {
                return lists.get(0);
            }

            Queue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
                @Override
                public int compare(ListNode node1, ListNode node2) {
                    return node1.val - node2.val;
                }
            });
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                tail.next = node;
                if (node.next != null) {
                    queue.add(node.next);
                }
                tail = tail.next;
            }
            return dummy.next;
        }
    }

}
