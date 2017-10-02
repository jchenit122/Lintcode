package com.example.heap_hash;

import com.example.BFS.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenj240 on 9/7/17.
 * The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we
 * should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:
 * size=3, capacity=4
 * [null, 21, 14, null]
 * ↓    ↓
 * 9   null
 * ↓
 * null
 * The hash function is:
 * int hashcode(int key, int capacity) {
 * return key % capacity;
 * }
 * here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We
 * store them in the hash table by linked list.
 * rehashing this hash table, double the capacity, you will get:
 * size=3, capacity=8
 * index:   0    1    2    3     4    5    6   7
 * hash : [null, 9, null, null, null, 21, 14, null]
 * Given the original hash table, return the new hash table after rehashing
 * <p>
 * Notice
 * For negative integer in hash table, the position can be calculated as follow:
 * C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
 * Python: you can directly use -1 % 3, you will get 2 automatically.
 * Example
 * Given [null, 21->9->null, 14->null, null],
 * return [null, 9->null, null, null, null, 21->null, 14->null, null]
 */

public class Rehashing {
    public static void main(String[] args) {
        ListNode one = new ListNode(21);
        ListNode two = new ListNode(9);
        ListNode three = new ListNode(14);

        one.next = two;

        ListNode[] hashTable = new ListNode[] {null, one, three, null};

        Solution solution = new Rehashing().new Solution();
        ListNode[] rehashedTable = solution.rehashing(hashTable);
        for (ListNode node : rehashedTable) {
            if (node == null) {
                System.out.print("null" + " ");
            } else {
                System.out.print(node.val + " ");
            }
        }
    }

    public class Solution {
        /**
         * @param hashTable: A list of The first node of linked list
         *
         * @return: A list of The first node of linked list which have twice size
         */
        public ListNode[] rehashing(ListNode[] hashTable) {
            // write your code here
            if (hashTable == null) {
                return null;
            } ;
            int length = hashTable.length * 2;
            ListNode[] rehashedTable = new ListNode[length];
            if (hashTable.length == 0) {
                return rehashedTable;
            }
            List<ListNode> nodeList = getAllNodes(hashTable);
            for (ListNode node : nodeList) {
                if (node.val < 0) {
                    if (rehashedTable[(node.val % length + length) % length] != null) {
                        ListNode tail = rehashedTable[(node.val % length + length) % length];
                        while (tail.next!=null){
                            tail= tail.next;
                        }
                        tail.next = node;
                    } else {
                        rehashedTable[(node.val % length + length) % length] = node;
                    }
                } else {
                    if (rehashedTable[node.val % length] != null) {
                        ListNode tailOne =rehashedTable[node.val % length];
                        while (tailOne.next!=null){
                            tailOne= tailOne.next;
                        }
                        tailOne.next = node;
                    } else {
                        rehashedTable[node.val % length] = node;
                    }
                }
            }
            return rehashedTable;
        }

        private List<ListNode> getAllNodes(ListNode[] hashTable) {
            List<ListNode> nodeList = new ArrayList<>();
            for (ListNode node : hashTable) {
                while (node != null) {
                    nodeList.add(node);
                    ListNode pre = node;
                    node = node.next;
                    pre.next=null;
                }
            }
            return nodeList;
        }
    }
}
