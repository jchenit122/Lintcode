package high.frequent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenj240 on 9/30/17.
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 40,000.
 * The order of output does not matter.
 * Example
 * Given s = "cbaebabacd" p = "abc"
 * return [0, 6]
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

public class SubstringAnagrams {
    public static void main(String[] args) {
        Solution solution = new SubstringAnagrams().new Solution();
        System.out.print(solution.findAnagrams("babababababababababababab", "aba"));
    }

    public class Solution {
        /*
         * @param s: a string
         * @param p: a string
         * @return: a list of index
         */
        public List<Integer> findAnagrams(String s, String p) {
            // write your code here
            List<Integer> result = new ArrayList<>();
            int[] map = new int[26];
            int sLength = s.length();
            int pLength = p.length();

            for (char c : p.toCharArray()) {
                map[c - 'a']++;
            }

            int start = 0;
            int end = 0;
            int matched = 0;

            while (end < sLength) {
                if (map[s.charAt(end) - 'a'] >= 1) {
                    matched++;
                }
                map[s.charAt(end) - 'a']--;
                end++;
                if (matched == pLength) {
                    result.add(start);
                }
                if (end - start == pLength) {
                    if (map[s.charAt(start) - 'a'] >= 0) {
                        matched--;
                    }
                    map[s.charAt(start) - 'a']++;
                    start++;
                }
            }
            return result;
        }
    }

}
