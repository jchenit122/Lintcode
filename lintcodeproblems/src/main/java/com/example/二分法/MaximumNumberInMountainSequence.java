package com.example.二分法;

/**
 * Created by chenj240 on 8/8/17.
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 */

public class MaximumNumberInMountainSequence {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 4, 8, 6, 3};
        int[] numsOne = new int[] {10, 9, 8, 7};

        System.out.println(mountainSequence(nums));
        System.out.println(mountainSequence(numsOne));
    }

    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     *
     * @return then mountain top
     */
    private static int mountainSequence(int[] nums) {
        // Write your code here

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
