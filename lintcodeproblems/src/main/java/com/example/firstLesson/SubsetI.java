package com.example.firstLesson;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, return all possible subsets.
 * Created by chenj240 on 7/25/17.
 */

public class SubsetI {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3, 4};
        for (int i = 0; i < subsets(nums).size(); i++) {
            System.out.println(subsets(nums).get(i));
        }
    }

    /**
     * @param nums: A set of numbers.
     *
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);

        helper(result, nums, 0, new ArrayList<Integer>());

        //result.add(new ArrayList<Integer>());
//        for (int i =0; i<nums.length;i++){
//            int resultLength = result.size();
//            for (int j =0; j<resultLength; j++){
//                ArrayList<Integer> subset = new ArrayList<>();
//                subset.addAll(result.get(j));
//                subset.add(nums[i]);
//                result.add(subset);
//
//            }
//        }
        return result;
    }

    private static void helper(ArrayList<ArrayList<Integer>> result, int[] nums, int startIndex, ArrayList<Integer> subset) {
        // need add new array since add same reference produce wrong result
        result.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(result, nums, i+1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
