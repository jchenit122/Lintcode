package com.example.双指针_partition;

/**
 * Created by chenj240 on 8/31/17.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * Example
 * Given nums = [2, 7, 11, 15], target = 9
 * return [1, 2]
 */

public class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        Solution solution = new TwoSumInputArrayIsSorted().new Solution();
        int[] result = solution.twoSum(nums, 9);
        System.out.println(result[0]);
        System.out.print(result[1]);
    }

    public class Solution {
        /*
         * @param nums: an array of Integer
         * @param target: target = nums[index1] + nums[index2]
         * @return: [index1 + 1, index2 + 1] (index1 < index2)
         */
        public int[] twoSum(int[] nums, int target) {
            // write your code here
            int[] result = new int[2];
            if (nums == null || nums.length < 2) {
                return result;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    return result;
                }
                if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return result;
        }
    }
}
