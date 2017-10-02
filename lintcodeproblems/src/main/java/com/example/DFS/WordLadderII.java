package com.example.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 8/23/17.
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */

public class WordLadderII {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        String start = "hit";
        String end = "cog";
        Solution solution = new WordLadderII().new Solution();
        List<List<String>> result = solution.findLadders(start, end, dict);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public class Solution {
        /**
         * @param start, a string
         * @param end,   a string
         * @param dict,  a set of string
         *
         * @return a list of lists of string
         */
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            // write your code here
            List<List<String>> results = new ArrayList<>();

            Map<String, Integer> distance = new HashMap<>();
            Map<String, List<String>> wordMap = new HashMap<>();
            dict.add(end);
            dict.add(start);

            bfs(dict, distance, wordMap, start);

            List<String> path = new ArrayList<>();

            dfs(start, end, path, wordMap, distance, results);

            return results;
        }

        private void bfs(Set<String> dict, Map<String, Integer> distance, Map<String, List<String>> wordMap, String start) {
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            for (String s : dict) {
                wordMap.put(s, new ArrayList<String>());
            }
            distance.put(start, 0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    for (String next : getNextWords(dict, word)) {
                        wordMap.get(next).add(word);
                        if (!distance.containsKey(next)) {
                            queue.add(next);
                            distance.put(next, distance.get(word) + 1);
                        }
                    }
                }
            }
        }

        private void dfs(String start,
                String end,
                List<String> path,
                Map<String, List<String>> wordMap,
                Map<String, Integer> distance,
                List<List<String>> results) {
            path.add(end);
            if (end.equals(start)) {
                Collections.reverse(path);
                results.add(new ArrayList<String>(path));
                Collections.reverse(path);
            } else {
                for (String s : wordMap.get(end)) {
                    if (distance.containsKey(s) && distance.get(end) == distance.get(s) + 1) {
                        dfs(start, s, path, wordMap, distance, results);
                    }

                }
            }
            path.remove(path.size() - 1);
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
