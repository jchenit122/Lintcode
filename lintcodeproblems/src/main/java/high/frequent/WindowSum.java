package high.frequent;

/**
 * Created by chenj240 on 9/21/17.
 * Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array,
 * find the sum of the element inside the window at each moving.
 * Example
 * For array [1,2,7,8,5], moving window size k = 3.
 * 1 + 2 + 7 = 10
 * 2 + 7 + 8 = 17
 * 7 + 8 + 5 = 20
 * return [10,17,20]
 */

public class WindowSum {
    public static void main(String[] args) {
        Solution solution = new  WindowSum().new Solution();
        int[] nums = new int[]{1,2,7,8,5};
        int[] result = solution.winSum(nums,1);
        for (int i: result){
            System.out.print(i+" ");
        }
    }
        public class Solution {
        /**
         * @param nums a list of integers.
         *
         * @return the sum of the element inside the window at each moving.
         */
        public int[] winSum(int[] nums, int k) {
            // write your code here
            if (nums == null|| nums.length==0){
                return nums;
            }
            if (k>=nums.length){
                return nums;
            }
            int[] result = new int[nums.length-k+1];

            for (int i =0 ;i< nums.length-k+1;i++){
                int sum =0;
                for (int j=i;j<i+k;j++){
                    sum+= nums[j];
                }
                result[i] = sum;
            }
            return result;
        }
    }


}
