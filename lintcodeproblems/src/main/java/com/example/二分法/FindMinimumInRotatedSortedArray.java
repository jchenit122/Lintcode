package com.example.二分法;

/**
 * Created by chenj240 on 8/9/17.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 */

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }

    /**
     * @param nums: a rotated sorted array
     *
     * @return: the minimum number in the array
     */
    private static int findMin(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int lastElement = nums[nums.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > lastElement) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
