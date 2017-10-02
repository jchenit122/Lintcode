package com.example.heap_hash;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenj240 on 9/7/17.
 * Find K-th largest element in an array. and N is much larger than k.
 * Notice
 * You can swap elements in the array
 * <p>
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 */

public class KthLargestElementII {
    public static void main(String[] args) {
        int[] nums = new int[] {9, 3, 2, 4, 8};
        Solution solution = new KthLargestElementII().new Solution();
        System.out.print(solution.kthLargestElement2(nums, 3));
    }

    public class Solution {
        /*
         * @param nums: an integer unsorted array
         * @param k: an integer from 1 to n
         * @return: the kth largest element
         */
        public int kthLargestElement2(int[] nums, int k) {
            // write your code here
            if (nums == null || nums.length == 0 || k <= 0) {
                return 0;
            }
            Queue<Integer> queue = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
}
