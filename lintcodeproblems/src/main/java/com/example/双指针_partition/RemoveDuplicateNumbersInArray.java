package com.example.双指针_partition;

import java.util.Arrays;

/**
 * Created by chenj240 on 8/31/17.
 * Given an array of integers, remove the duplicate numbers in it.
 * You should:
 * 1. Do it in place in the array.
 * 2. Move the unique numbers to the front of the array.
 * 3. Return the total number of the unique numbers.
 * <p>
 * Notice
 * You don't need to keep the original order of the integers
 * <p>
 * Example
 * Given nums = [1,3,1,4,4,2], you should:
 * <p>
 * Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
 * Return the number of unique integers in nums => 4.
 * Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.
 * <p>
 * Challenge
 * Do it in O(n) time complexity.
 * Do it in O(nlogn) time without extra space.
 */

public class RemoveDuplicateNumbersInArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,1,4,4,2};
        Solution solution = new RemoveDuplicateNumbersInArray().new Solution();
        System.out.print(solution.deduplication(nums));
    }

    public class Solution {
        /**
         * @param nums an array of integers
         *
         * @return the number of unique integers
         */
        public int deduplication(int[] nums) {
            // Write your code here
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            // 1 1 1 3 4 4
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != nums[index]) {
                    nums[++index] =nums[i];
                }
            }
            return index+1;
        }
    }
}
