package com.example.双指针_partition;

/**
 * Created by chenj240 on 9/5/17.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Notice
 * You are not suppose to use the library's sort function for this problem.
 * You should do it in-place (sort numbers in the original array).
 *
 * Example
 * Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
 *
 * Challenge
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2};
        Solution solution = new SortColors().new Solution();
        solution.sortColors(nums);
        for (int i : nums){
            System.out.print(i+ " ");
        }
    }

    class Solution {
        /**
         * @param nums: A list of integer which is 0, 1 or 2
         *
         * @return: nothing
         */
        public void sortColors(int[] nums) {
            // write your code here
            if (nums == null || nums.length < 2) {
                return;
            }
            int left = 0;
            int right = nums.length - 1;
            int i = 0;
            while (i <= right) {
                if (nums[i] == 0) {
                    swap(nums, i, left);
                    i++;
                    left++;
                } else if (nums[i] == 1) {
                    i++;
                } else {
                    swap(nums, i, right);
                    right--;
                }
            }
        }

        private void swap(int[] nums, int i, int left) {
            int temp = nums[i];
            nums[i] = nums[left];
            nums[left] = temp;
        }
    }
}
