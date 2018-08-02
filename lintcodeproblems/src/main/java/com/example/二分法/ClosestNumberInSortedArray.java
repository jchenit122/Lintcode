package com.example.二分法;

/**
 * Created by chenj240 on 8/8/17.
 * Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.
 */

public class ClosestNumberInSortedArray {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 4, 6};
        System.out.println(closestNumber(nums, 1));
        System.out.println(closestNumber(nums, 3));
        System.out.println(closestNumber(nums, 5));
    }

    /**
     * @param A      an integer array sorted in ascending order
     * @param target an integer
     *
     * @return an integer
     */
    private static int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int s = 98;
        if (A[start] == target) {
            return start;
        }
        if (A[end] == end) {
            return end;
        }

        if (Math.abs(target - A[start]) > Math.abs(target - A[end])) {
            return end;
        } else {
            return start;
        }
    }
}
