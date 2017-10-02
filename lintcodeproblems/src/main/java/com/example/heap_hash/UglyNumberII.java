package com.example.heap_hash;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 9/7/17.
 * Ugly number is a number that only have factors 2, 3 and 5.
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * <p>
 * Notice
 * Note that 1 is typically treated as an ugly number.
 * Example
 * If n=9, return 10.
 * Challenge
 * O(n log n) or O(n) time.
 */

public class UglyNumberII {
    public static void main(String[] args) {
        Solution solution = new UglyNumberII().new Solution();
        System.out.print(solution.nthUglyNumber(7));
    }

    public class Solution {
        /*
         * @param n: An integer
         * @return: the nth prime number as description.
         */
        public int nthUglyNumber(int n) {
            // write your code here
            if (n <= 0) {
                return 0;
            }
            Queue<Long> queue = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();
            queue.add(Long.valueOf(1));
            set.add(Long.valueOf(1));
            for (int i = 1; i < n; i++) {
                long j = queue.poll();
                if (!set.contains(j * 2)) {
                    queue.add(j * 2);
                    set.add(j * 2);

                }
                if (!set.contains(j * 3)) {
                    queue.add(j * 3);
                    set.add(j * 3);
                }
                if (!set.contains(j * 5)) {
                    queue.add(j * 5);
                    set.add(j * 5);
                }
            }
            return queue.peek().intValue();
        }
    }
}
