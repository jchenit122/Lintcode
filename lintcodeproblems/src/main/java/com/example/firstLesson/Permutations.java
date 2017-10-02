package com.example.firstLesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenj240 on 7/31/17.
 * Given a list of numbers, return all possible permutations.
 */

public class Permutations {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3};
        for (int i = 0; i < permute(nums).size(); i++) {
            System.out.println(permute(nums).get(i));
        }
    }

    /**
     * @param nums: A list of integers.
     *
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        helper(nums, results, new ArrayList<Integer>());
        return results;
    }

    private static void helper(int[] nums, List<List<Integer>> results, List<Integer> permutation) {

        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            helper(nums, results , permutation);
            permutation.remove(permutation.size()-1);
        }
    }
}
