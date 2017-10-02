package com.example.双指针_partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenj240 on 9/5/17.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, 2, -1, -1, -4};
        Solution solution = new ThreeSum().new Solution();
        List<List<Integer>> results = solution.threeSum(nums);
        for (List<Integer> list : results) {
            System.out.print(list);
        }
    }

    public class Solution {

        /*
         * @param numbers: Give an array numbers of n integer
         * @return: Find all unique triplets in the array which gives the sum of zero.
         */
        public List<List<Integer>> threeSum(int[] numbers) {
            List<List<Integer>> results = new ArrayList<>();
            if (numbers == null || numbers.length == 0) {
                return results;
            }
            Arrays.sort(numbers);
            for (int i = 0; i < numbers.length - 2; i++) {
                int left = i + 1;
                int right = numbers.length - 1;
                if (i > 0 && numbers[i] == numbers[i - 1]) {
                    continue;
                }
                while (left < right) {
                    if (numbers[left] + numbers[right] == -numbers[i]) {
                        List<Integer> combination = new ArrayList<>();
                        combination.add(numbers[i]);
                        combination.add(numbers[left]);
                        combination.add(numbers[right]);
                        results.add(combination);
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        while (left < right && right + 1 < numbers.length && numbers[right] == numbers[right + 1]) {
                            right--;
                        }

                    } else if (numbers[left] + numbers[right] > -numbers[i]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return results;
        }
    }
}

