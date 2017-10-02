package com.example.LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenj240 on 8/29/17.
 * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].  O(nlogn)
 */

public class SubarraySumClosest {
    public static void main(String[] args) {
        int[] nums = new int[] {-3, 3, 1, -3, 5};
        Solution solution = new SubarraySumClosest().new Solution();
        int[] result = solution.subarraySumClosest(nums);
        if (result != null) {
            System.out.println(result[0]);
            System.out.print(result[1]);
        }
    }

    public class Solution {
        /**
         * @param nums: A list of integers
         *
         * @return: A list of integers includes the index of the first number
         * and the index of the last number
         */
        public int[] subarraySumClosest(int[] nums) {
            // write your code here
            int[] result = new int[2];
            if (nums == null || nums.length == 0) {
                return result;
            }
            int length = nums.length;
            Pair[] preFixSum = new Pair[length + 1];
            preFixSum[0] = new Pair(0, 0);
            for (int i = 1; i < preFixSum.length; i++) {
                preFixSum[i] = new Pair(i, nums[i - 1] + preFixSum[i - 1].sum);
            }

            Arrays.sort(preFixSum, new Comparator<Pair>() {
                @Override
                public int compare(Pair a, Pair b) {
                    return a.sum - b.sum;
                }
            });

            int minGap = Integer.MAX_VALUE;
            for (int i = 1; i < preFixSum.length; i++) {
                if (preFixSum[i].sum - preFixSum[i - 1].sum < minGap) {
                    minGap = preFixSum[i].sum - preFixSum[i - 1].sum;
                    int[] temp = new int[] {preFixSum[i].index-1, preFixSum[i - 1].index-1};
                    Arrays.sort(temp);
                    result[0] = temp[0]+1;
                    result[1] = temp[1];
                }
            }
            return result;
        }

        class Pair {
            int index;
            int sum;

            public Pair(int index, int sum) {
                this.index = index;
                this.sum = sum;
            }
        }
    }

}
