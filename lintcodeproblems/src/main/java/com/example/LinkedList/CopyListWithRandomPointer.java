package com.example.LinkedList;

/**
 * Created by chenj240 on 8/29/17.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Could you solve it with O(1) space?
 */

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);

        one.next = two;
        two.next = three;
        one.random = three;

        Solution solution = new CopyListWithRandomPointer().new Solution();

        System.out.print(solution.copyRandomList(one).label);

    }
        public class Solution {
        /**
         * @param head: The head of linked list with a random pointer.
         * @return: A new head of a deep copy of the list.
         */
        public RandomListNode copyRandomList(RandomListNode head) {
            // write your code here
            if (head == null){
                return null;
            }

            RandomListNode next = null;
            RandomListNode current = head;
            while (current!=null){
                RandomListNode randomListNode = new RandomListNode(current.label);
                next = current.next;
                current.next = randomListNode;
                randomListNode.next = next;
                current = next;
            }

            RandomListNode newCurrent = head;
            while (newCurrent!=null){
                if (newCurrent.random!=null){
                    newCurrent.next.random = newCurrent.random.next;
                }
                newCurrent = newCurrent.next.next;
            }

            RandomListNode dummyOld = new RandomListNode(0);
            RandomListNode lastNodeOld =dummyOld;
            RandomListNode dummyNew = new RandomListNode(0);
            RandomListNode lastNodeNew =dummyNew;
            RandomListNode start = head;
            while (start!=null){
                lastNodeOld.next = start;
                lastNodeNew.next = start.next;
                start = start.next.next;
                lastNodeOld = lastNodeOld.next;
                lastNodeNew = lastNodeNew.next;
            }
            head = dummyOld.next;
            return dummyNew.next;
        }
    }

}
