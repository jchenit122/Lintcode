package com.example.LinkedList;

import com.example.BFS.ListNode;

/**
 * Created by chenj240 on 8/24/17.
 * Given a node from a cyclic linked list which has been sorted,
 * write a function to insert a value into the list such that it remains a cyclic sorted list.
 * The given node can be any single node in the list. Return the inserted new node.
 */

public class InsertIntoACyclicSortedList {
    public static void main(String[] args) {

        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        ListNode one = new ListNode(1);

        three.next = five;
        five.next = one;
        one.next = three;

        print(three, three);
        Solution solution = new InsertIntoACyclicSortedList().new Solution();

        ListNode result = solution.insert(three, 4);
        print(result, result);

        ListNode testOne = new ListNode(1);
        testOne.next = testOne;
        ListNode resultOne = solution.insert(testOne, 4);
        print(resultOne, resultOne);

        ListNode two = new ListNode(2);
        ListNode twoOne = new ListNode(2);
        ListNode twoTwo = new ListNode(2);
        two.next = twoOne;
        twoOne.next = twoTwo;
        twoTwo.next = two;
        ListNode resultTwo = solution.insert(two, 3);
        print(resultTwo, resultTwo);

    }

    private static void print(ListNode node, ListNode head) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node == head) {
                break;
            }
            System.out.print("->");
        }
        System.out.println();
    }

    public class Solution {
        /**
         * @param node a list node in the list
         * @param x    an integer
         *
         * @return the inserted new list node
         */
        public ListNode insert(ListNode node, int x) {
            // Write your code here

            if (node == null) {
                ListNode newNode = new ListNode(x);
                newNode.next = newNode;
                return newNode;
            }

            ListNode current = node;
            ListNode pre = null;
            do {
                pre = current;
                current = current.next;
                if (x >= pre.val && x <= current.val) {
                    break;
                }
                if (pre.val > current.val && (x > pre.val || x < current.val)) {
                    break;
                }

            } while (current != node);

            ListNode newNode = new ListNode(x);
            pre.next = newNode;
            newNode.next = current;
            return newNode;
        }
    }
}
