package com.example.二分法;

/**
 * Created by chenj240 on 8/9/17.
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 4, 5, 6, 7};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 2));
        System.out.println(search(nums, 3));
        System.out.println(search(nums, 5));
    }

    /**
     * @param A      : an integer rotated sorted array
     * @param target :  an integer to be searched
     *               return : an integer
     */
    private static int search(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[start]) {
                if (target >= A[start] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }

            } else if (A[mid] < A[start]) {
                if (target <= A[end] && target >= A[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                return mid;
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}
