package com.example.LinkedList;

import com.example.BFS.ListNode;

/**
 * Created by chenj240 on 8/30/17.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

public class SortList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next =four;
        four.next=five;

        Solution solution = new SortList().new Solution();
        ListNode result = solution.sortList(one);
        System.out.println(result);
    }

    public class Solution {
        /**
         * @param head: The head of linked list.
         *
         * @return: You should return the head of the sorted linked list,
         * using constant space complexity.
         */
        public ListNode sortList(ListNode head) {
            // write your code here
            if (head == null || head.next == null) {
                return head;
            }

            ListNode middle = findMiddle(head);
            ListNode right = sortList(middle.next);
            middle.next = null;
            ListNode left = sortList(head);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode lastNode = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    lastNode.next = left;
                    left = left.next;
                } else {
                    lastNode.next = right;
                    right = right.next;
                }
                lastNode = lastNode.next;
            }
            if (left != null) {
                lastNode.next = left;
            }
            if (right != null) {
                lastNode.next = right;
            }
            return dummy.next;
        }

        private ListNode findMiddle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
