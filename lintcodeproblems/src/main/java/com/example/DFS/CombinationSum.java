package com.example.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenj240 on 8/22/17.
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 */

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;

        Solution solution = new CombinationSum().new Solution();
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public class Solution {
        /**
         * @param candidates: A list of integers
         * @param target:An   integer
         *
         * @return: A list of lists of integers
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // write your code here
            List<List<Integer>> results = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return results;
            }
            Arrays.sort(candidates);
            helper(candidates, target, results, new ArrayList<Integer>(), 0);
            return results;
        }

        private void helper(int[] candidates, int target, List<List<Integer>> results, ArrayList<Integer> combination, int startIndex) {

            // exit
            if (target == 0) {
                results.add(new ArrayList<>(combination));
                return;
            }

            // dfs
            for (int i = startIndex; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                combination.add(candidates[i]);
                helper(candidates, target - candidates[i], results, combination,i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
