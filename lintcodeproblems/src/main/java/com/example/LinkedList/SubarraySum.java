package com.example.LinkedList;

import java.util.ArrayList;

/**
 * Created by chenj240 on 8/25/17.
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 * //Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 1, 2, -3, 4};
        Solution solution = new SubarraySum().new Solution();
        ArrayList<Integer> result = solution.subarraySum(nums);
        System.out.print(result);
    }

    public class Solution {
        /**
         * @param nums: A list of integers
         *
         * @return: A list of integers includes the index of the first number
         * and the index of the last number
         */
        public ArrayList<Integer> subarraySum(int[] nums) {
            // write your code here
            ArrayList<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            int length = nums.length;
            int[] preFixSum = new int[length + 1];
            preFixSum[0] = 0;
            for (int i = 1; i < preFixSum.length; i++) {
                preFixSum[i] = nums[i - 1] + preFixSum[i - 1];
            }

            for (int j = 0; j < preFixSum.length; j++) {
                for (int i = j+1; i < preFixSum.length; i++) {
                    if (preFixSum[j] == preFixSum[i]) {
                        result.add(j);
                        result.add(i-1);
                        return result;
                    }
                }
            }

            return result;
        }

    }
}
