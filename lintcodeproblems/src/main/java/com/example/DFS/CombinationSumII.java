package com.example.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenj240 on 8/22/17.
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */

public class CombinationSumII {

    public static void main(String[] args) {

        int[] candidates = new int[] {10, 1, 6, 7, 2, 1, 5};
        int target = 8;

        Solution solution = new CombinationSumII().new Solution();
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public class Solution {
        /**
         * @param num:    Given the candidate numbers
         * @param target: Given the target number
         *
         * @return: All the combinations that sum to target
         */
        public List<List<Integer>> combinationSum2(int[] num, int target) {
            // write your code here
            List<List<Integer>> results = new ArrayList<>();
            if (num == null || num.length == 0) {
                return results;
            }
            Arrays.sort(num);
            helper(num, target, results, new ArrayList<Integer>(), 0);
            return results;
        }

        private void helper(int[] num, int target, List<List<Integer>> results, ArrayList<Integer> combination, int startIndex) {

            if (target == 0) {
                results.add(new ArrayList<>(combination));
                return;
            }
            for (int i = startIndex; i < num.length; i++) {
                if (num[i] > target) {
                    break;
                }
                if (i > startIndex && num[i] == num[i - 1]) {
                    continue;
                }
                combination.add(num[i]);
                helper(num, target - num[i], results, combination, i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
