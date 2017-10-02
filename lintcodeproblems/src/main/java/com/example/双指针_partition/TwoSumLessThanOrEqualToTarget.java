package com.example.双指针_partition;

import java.util.Arrays;

/**
 * Created by chenj240 on 8/31/17.
 * Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number.
 * Please return the number of pairs.
 * Example
 * Given nums = [2, 7, 11, 15], target = 24.
 * Return 5.
 * 2 + 7 < 24
 * 2 + 11 < 24
 * 2 + 15 < 24
 * 7 + 11 < 24
 * 7 + 15 < 25
 */

public class TwoSumLessThanOrEqualToTarget {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        Solution solution = new TwoSumLessThanOrEqualToTarget().new Solution();
        System.out.println(solution.twoSum5(nums, 24));
    }

    public class Solution {
        /*
         * @param nums: an array of integer
         * @param target: an integer
         * @return: an integer
         */
        public int twoSum5(int[] nums, int target) {
            // write your code here
            if (nums == null) {
                return 0;
            }
            Arrays.sort(nums);
            int count = 0;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }

            return count;
        }
    }
}
