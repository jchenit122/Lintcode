package com.example.LinkedList;

/**
 * Created by chenj240 on 8/30/17.
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = new int[] {3};
        int[] B = new int[] { 4 };

        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.print(solution.findMedianSortedArrays(A, B));

    }

    class Solution {
        /**
         * @param A: An integer array.
         * @param B: An integer array.
         *
         * @return: a double whose format is *.5 or *.0
         */
        public double findMedianSortedArrays(int[] A, int[] B) {
            // write your code here
            int lengthA = A.length;
            int lengthB = B.length;
            int k = lengthA + lengthB;
            double result;
            if (k % 2 == 1) {
                result = findKthNumber(A, 0, lengthA, B, 0, lengthB, k / 2 + 1) * 1.0;
            } else {
                result = (findKthNumber(A, 0, lengthA, B, 0, lengthB, k / 2) + findKthNumber(A, 0, lengthA, B, 0, lengthB, k / 2 + 1)) / 2.0;
            }
            return result;
        }

        private int findKthNumber(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
            if (startA >= endA) {
                return B[startB + k - 1];
            }

            if (startB >= endB) {
                return A[startA + k - 1];
            }

            if (k == 1) {
                return Math.min(A[startA], B[startB]);
            }

            int AKey = startA + k / 2 - 1 < endA ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
            int BKey = startB + k / 2 - 1 < endB ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

            if (AKey > BKey) {
                return findKthNumber(A, startA, endA, B, startB + k / 2, endB, k - k / 2);
            } else {
                return findKthNumber(A, startA + k / 2, endA, B, startB, endB, k - k / 2);
            }
        }
    }
}
