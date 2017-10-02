package com.example.LinkedList;

import com.example.BFS.ListNode;

/**
 * Created by chenj240 on 8/30/17.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p>
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 原链表结构会发生变化
 */

public class ReverseNodesInKGroup {
    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode result = solution.reverseKGroup(one, 2);
       print(result);

        System.out.println();
        ListNode resultOne = solution.reverseKGroup(one, 3);
        print(resultOne);
    }

    private static void print(ListNode node) {
        while (node != null) {
            if (node.next == null) {
                System.out.print(node.val);
            } else {
                System.out.print(node.val + "->");
            }
            node = node.next;
        }
    }

    public class Solution {
        /*
         * @param head: a ListNode
         * @param k: An integer
         * @return: a ListNode
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            // write your code here
            if (head == null || head.next == null || k <= 1) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            while (pre != null) {
                pre = reverseKNodes(pre, k);
            }
            return dummy.next;
        }

        // Dummy -> n1->n2->n3...->nk-> nk+1
        // dummy -> nk->nk-1->...n2->n1->nk+1
        // return n1 or null
        private ListNode reverseKNodes(ListNode pre, int k) {
            ListNode n1 = pre.next;
            ListNode nk = pre;
            for (int i = 0; i < k; i++) {
                if (nk == null) {
                    return null;
                }
                nk = nk.next;
            }
            if (nk ==null){
                return null;
            }
            ListNode nkplus1 = nk.next;
            nk.next = null;
            reverse(nk, n1);
            pre.next = nk;
            n1.next = nkplus1;
            return n1;
        }

        //n1->n2->n3...->nk
        //nk->..-> n1
        // n2->n1
        private void reverse(ListNode nk, ListNode n1) {
            ListNode pre = null;
            while (n1 != nk) {
                ListNode current = n1.next;
                n1.next = pre;
                pre =n1;
                n1 = current;
            }
            n1.next = pre;
        }
    }
}
