package com.example.LinkedList;

import com.example.BFS.ListNode;

/**
 * Created by chenj240 on 8/29/17.
 * Given a linked list, determine if it has a cycle in it.
 */

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;
        three.next = one;

        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        four.next = five;

        Solution solution = new LinkedListCycle().new Solution();

        System.out.println(solution.hasCycle(one));
        System.out.println(solution.hasCycle(four));

    }

    public class Solution {
        /**
         * @param head: The first node of linked list.
         *
         * @return: True if it has a cycle, or false
         */
        public boolean hasCycle(ListNode head) {
            // write your code here
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != null && fast != null && fast.next != null) {
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }
}
