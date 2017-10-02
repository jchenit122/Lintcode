package com.example.双指针_partition;

/**
 * Created by chenj240 on 9/5/17.
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * <p>
 * Notice
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 * If all elements in nums are smaller than k, then return nums.length
 * <p>
 * Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * Challenge
 * Can you partition the array in-place and in O(n)?
 */

public class PartitionArray {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 1};
        Solution solution = new PartitionArray().new Solution();
        System.out.print(solution.partitionArray(nums, 5));
    }

    public class Solution {
        /**
         * @param nums: The integer array you should partition
         * @param k:    As description
         *              return: The index after partition
         */
        public int partitionArray(int[] nums, int k) {
            //write your code here
            if (nums == null || nums.length ==0){
                return 0;
            }
            int left = 0;
            int right = nums.length-1;
            while (left<right){
                while (left<right&& nums[left]<k){
                    left++;
                }
                while (left<right&& nums[right]>=k ){
                    right--;
                }

                if (left<right){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }
            if (nums[left]<k){
                return left+1;
            }
            return left;
        }
    }
}
