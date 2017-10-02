package com.example.firstLesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenj240 on 8/1/17.
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 */

public class PermutationsII {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 2};
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

        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        for (int i = 0; i<nums.length;i++){
            visited[i] = 0;
        }
        helper(nums, results, new ArrayList<Integer>(), visited);
        return results;
    }

    private static void helper(int[] nums, List<List<Integer>> results, List<Integer> permutation, int[] visited) {

        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] ==1  || (i>0 && nums[i] == nums[i-1] && visited[i-1] ==0)){
                continue;
            }
            visited[i]=1;
            permutation.add(nums[i]);
            helper(nums, results , permutation, visited);
            permutation.remove(permutation.size()-1);
            visited[i]=0;
        }
    }
}
