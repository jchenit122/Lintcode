package com.example.二分法;

/**
 * Created by chenj240 on 8/9/17.
 * Find a peak element in this array. Return the index of the peak.
 */

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(findPeak(nums));
    }

    /**
     * @param A: An integers array.
     *
     * @return: return any of peek positions.
     */
    private static int findPeak(int[] A) {
        // write your code here

        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] > A[start + 1] && A[start] > A[start - 1]) {
            return start;
        }
        if (A[end] > A[end + 1] && A[end] > A[end - 1]) {
            return end;
        }
        return -1;
    }
}
