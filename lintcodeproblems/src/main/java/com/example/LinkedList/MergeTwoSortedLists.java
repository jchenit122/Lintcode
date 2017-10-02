package com.example.LinkedList;

import com.example.BFS.ListNode;

/**
 * Created by chenj240 on 8/25/17.
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(8);
        ListNode four = new ListNode(11);
        ListNode five = new ListNode(15);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode six = new ListNode(16);

        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode result = solution.mergeTwoLists(one, six);

        while (result != null) {
            if (result.next != null) {
                System.out.print(result.val + "->");
            } else {
                System.out.print(result.val);
            }
            result = result.next;
        }
    }

    public class Solution {
        /**
         * @param l1 is the head of the linked list
         * @param l2 is the head of the linked list
         *
         * @return: ListNode head of linked list
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // write your code here
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(0);
            ListNode lastNode = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    lastNode.next = l1;
                    l1 = l1.next;
                } else {
                    lastNode.next = l2;
                    l2 = l2.next;
                }
                lastNode = lastNode.next;
            }
            if (l1 != null) {
                lastNode.next = l1;
            } else {
                lastNode.next = l2;
            }
            return dummy.next;
        }
    }
}
