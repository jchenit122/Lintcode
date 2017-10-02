package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/18/17.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Notice
 * This problem have two method which is Greedy and Dynamic Programming.
 * The time complexity of Greedy method is O(n).
 * The time complexity of Dynamic Programming method is O(n^2).
 * <p>
 * We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic
 * programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 * Example
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] A = new int[] {0,8,2,0,9};
        System.out.print(solution.canJump(A));
    }

    public class Solution {
        /**
         * @param A: A list of integers
         *
         * @return: The boolean answer
         */
        public boolean canJump(int[] A) {
            // wirte your code here
            if (A == null) {
                return false;
            }
            if (A.length==0){
                return true;
            }

            if (A.length==1){
                return true;
            }

            boolean[] f = new boolean[A.length];

            if (A[0] != 0) {
                f[0] = true;
            }else {
                return false;
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = 1; j <= A[i] && i + j < A.length; j++) {
                    f[i + j] = true;
                }
            }

            for (boolean i : f) {
                if (!i) {
                    return false;
                }
            }
            return true;
        }
    }

}
