package com.example.firstLesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Each element in a subset must be in non-descending order.
 * The ordering between two subsets is free.
 * The solution set must not contain duplicate subsets.
 * Created by chenj240 on 7/26/17.
 */

public class SubsetII {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3};
        for (int i = 0; i < subsetsWithDup(nums).size(); i++) {
            System.out.println(subsetsWithDup(nums).get(i));
        }
    }

    /**
     * @param nums: A set of numbers.
     *
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        helper(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    private static void helper(ArrayList<ArrayList<Integer>> result, int[] nums, int startIndex, ArrayList<Integer> subset) {
        // need add new array since add same reference produce wrong result
        result.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            helper(result, nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
