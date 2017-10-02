package com.example.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenj240 on 8/22/17.
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */

public class PalindromePartitioning {

    public static void main(String[] args) {

        String a = "aab";
        String b = "abccba";

        Solution solution = new PalindromePartitioning().new Solution();
        List<List<String>> result = solution.partition(a);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        List<List<String>> resultB = solution.partition(b);
        for (int i = 0; i < resultB.size(); i++) {
            System.out.println(resultB.get(i));
        }
    }

    public class Solution {
        /**
         * @param s: A string
         *
         * @return: A list of lists of string
         */
        public List<List<String>> partition(String s) {
            // write your code here
            List<List<String>> results = new ArrayList<>();
            if (s == null) {
                return results;
            }

            helper(s, 0, results, new ArrayList<String>());
            return results;
        }

        private void helper(String source, int startIndex, List<List<String>> results, ArrayList<String> subset) {
            //exit
            if (startIndex == source.length()) {
                results.add(new ArrayList<>(subset));
                return;
            }

            for (int i = startIndex; i < source.length(); i++) {
                if (!isValid(source.substring(startIndex, i + 1))) {
                    continue;
                }
                subset.add(source.substring(startIndex, i + 1));
                helper(source, i + 1, results, subset);
                subset.remove(subset.size() - 1);
            }
        }

        private boolean isValid(String substring) {
            for (int i = 0, j = substring.length() - 1; i < j; i++, j--) {
                if (substring.charAt(i) != substring.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
