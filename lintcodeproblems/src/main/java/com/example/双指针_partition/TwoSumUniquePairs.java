package com.example.双指针_partition;

import java.util.Arrays;

/**
 * Created by chenj240 on 8/31/17.
 * Given an array of integers, find how many unique pairs in the array
 * such that their sum is equal to a specific target number. Please return the number of pairs.
 * Example
 * Given nums = [1,1,2,45,46,46], target = 47
 * return 2
 * 1 + 46 = 47
 * 2 + 45 = 47
 */

public class TwoSumUniquePairs {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 45, 46, 46};
        Solution solution = new TwoSumUniquePairs().new Solution();
        System.out.println(solution.twoSum6(nums, 47));

        int[] numsOne = new int[] {7, 11, 11, 1, 2, 3, 4};
        System.out.println(solution.twoSum6(numsOne, 22));

    }

    public class Solution {
        /**
         * @param nums   an array of integer
         * @param target an integer
         *
         * @return an integer
         */
        public int twoSum6(int[] nums, int target) {
            // Write your code here
            if (nums == null || nums.length < 2) {
                return 0;
            }
            Arrays.sort(nums);
            int count = 0;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    count++;
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }

            return count;
        }
    }
}
