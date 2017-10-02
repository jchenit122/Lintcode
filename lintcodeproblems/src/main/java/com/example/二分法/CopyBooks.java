package com.example.二分法;

/**
 * Created by chenj240 on 8/9/17.
 */

public class CopyBooks {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        System.out.println(copyBooks(nums, 2));
    }

    /**
     * @param pages: an array of integers
     * @param k:     an integer
     *
     * @return: an integer
     */
    private static int copyBooks(int[] pages, int k) {
        // write your code here

        if (pages == null || pages.length == 0) {
            return -1;
        }

        //find total pages and book has max pages

        int total = 0;
        int max = pages[0];
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (pages[i] > max) {
                max = pages[i];
            }
        }

        int start = max, end = total;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countCopiers(pages, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (countCopiers(pages, start) <= k) {
            return start;
        } else {
            return end;
        }
    }

    private static int countCopiers(int[] pages, int mid) {
        int copiers = 1;
        int sum = pages[0];
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > mid) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }
        return copiers;
    }
}
