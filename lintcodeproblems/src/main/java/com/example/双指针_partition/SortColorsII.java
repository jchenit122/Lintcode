package com.example.双指针_partition;

/**
 * Created by chenj240 on 9/5/17.
 * Given an array of n objects with k different colors (numbered from 1 to k),
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 * <p>
 * Example
 * Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * <p>
 * Challenge
 * A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using
 * extra memory?
 * <p>
 * nlogk
 */

public class SortColorsII {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 1, 4, 1, 4, 3, 2, 1};
        Solution solution = new SortColorsII().new Solution();
        solution.sortColors2(nums, 4);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    class Solution {
        /**
         * @param colors: A list of integer
         * @param k:      An integer
         *
         * @return: nothing
         */
        public void sortColors2(int[] colors, int k) {
            // write your code here
            if (colors == null || colors.length < 2 || k <= 1) {
                return;
            }
            rainbowSort(colors, 1, k, 0, colors.length - 1);
        }

        private void rainbowSort(int[] colors, int startColor, int endColor, int startIndex, int endIndex) {

            if (startIndex >= endIndex){
                return;
            }

            if (startColor == endColor){
                return;
            }

            int left = startIndex;
            int right = endIndex;
            int midColor = startColor + (endColor - startColor) / 2;

            while (left <= right) {
                while (left <= right && colors[left] <= midColor) {
                    left++;
                }
                while (left <= right && colors[right] > midColor) {
                    right--;
                }

                if (left <= right) {
                    int temp = colors[left];
                    colors[left] = colors[right];
                    colors[right] = temp;
                    left++;
                    right--;
                }
            }
            rainbowSort(colors, startColor, midColor, startIndex, right);
            rainbowSort(colors, midColor+1, endColor, left, endIndex);
        }
    }
}
