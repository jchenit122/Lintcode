package com.example.heap_hash;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenj240 on 9/7/17.
 * Given an integer array, find the top k largest numbers in it.
 * Example
 * Given [3,10,1000,-99,4,100] and k = 3.
 * Return [1000, 100, 10].
 */

public class TopKLargestNumbers {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 10, 1000, -99, 4, 100};
        Solution solution = new TopKLargestNumbers().new Solution();
        int[] result = solution.topk(nums, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public class Solution {
        /*
         * @param nums: an integer array
         * @param k: An integer
         * @return: the top k largest numbers in array
         */
        public int[] topk(int[] nums, int k) {
            // write your code here
            if (nums == null || nums.length == 0 || k <= 0) {
                return null;
            }

            int[] result = new int[k];
            Queue<Integer> queue = new PriorityQueue<>();
            for (int i : nums) {
                queue.add(i);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            for (int i = k - 1; i >= 0; i--) {
                result[i] = queue.poll();
            }
            return result;
        }
    }
}
