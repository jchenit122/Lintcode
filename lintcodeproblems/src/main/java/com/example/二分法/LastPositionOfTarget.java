package com.example.二分法;

/**
 * Created by chenj240 on 8/8/17.
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 */

public class LastPositionOfTarget {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 2, 4, 5, 5};
        System.out.println(lastPosition(nums, 2));
        System.out.println(lastPosition(nums, 5));
        System.out.println(lastPosition(nums, 6));
    }

    /**
     * @param nums:   An integer array sorted in ascending order
     * @param target: An integer
     *
     * @return an integer
     */
    private static int lastPosition(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
}
