package com.example.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 8/23/17.
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */

public class WordLadder {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        String start = "hit";
        String end = "cog";
        Solution solution = new WordLadder().new Solution();
        System.out.print(solution.ladderLength(start, end, dict));
    }

    public class Solution {
        /**
         * @param start, a string
         * @param end,   a string
         * @param dict,  a set of string
         *
         * @return an integer
         */
        public int ladderLength(String start, String end, Set<String> dict) {
            // write your code here
            if (start.equals(end)) {
                return 1;
            }
            Queue<String> queue = new LinkedList<>();
            Set<String> set = new HashSet<>();
            set.add(start);
            dict.add(end);
            queue.add(start);
            int length = 0;
            while (!queue.isEmpty()) {
                length++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    if (word.equals(end)) {
                        return length;
                    } else {
                        for (String nextWord : getNextWords(dict, word)) {
                            if (!set.contains(nextWord)) {
                                queue.add(nextWord);
                                set.add(nextWord);
                            }
                        }
                    }

                }

            }
            return 0;
        }

        private List<String> getNextWords(Set<String> dict, String word) {
            int workLength = word.length();
            List<String> results = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (word.charAt(i) != j) {
                        String next = word.substring(0, i) + j + word.substring(i + 1, workLength);
                        if (dict.contains(next)) {
                            results.add(next);
                        }
                    }
                }
            }
            return results;
        }
    }
}
