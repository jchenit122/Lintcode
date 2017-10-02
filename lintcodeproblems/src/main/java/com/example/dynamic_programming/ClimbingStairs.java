package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/12/17.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.print(solution.climbStairs(3));
    }
        public class Solution {
        /**
         * @param n: An integer
         *
         * @return: An integer
         */
        public int climbStairs(int n) {
            // write your code here
            if (n==0){
                return 0;
            }
            if (n==1){
                return 1;
            }
            int[] f = new int[n];
            f[0] =1;
            f[1] =2;
            for (int i =2; i<n;i++){
                f[i] = f[i-1]+f[i-2];
            }
            return f[n-1];
        }
    }
}
