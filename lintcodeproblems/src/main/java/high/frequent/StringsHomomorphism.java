package high.frequent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenj240 on 9/19/17.
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to
 * the same character but a character may map to itself.
 * Notice
 * You may assume both s and t have the same length.
 * Example
 * Given s = "egg", t = "add", return true.
 * Given s = "foo", t = "bar", return false.
 * Given s = "paper", t = "title", return true.
 */

public class StringsHomomorphism {
    public static void main(String[] args) {
        Solution solution = new StringsHomomorphism().new Solution();
        System.out.print(solution.isIsomorphic("egg", "add"));
        System.out.print(solution.isIsomorphic("foo", "bar"));
        System.out.print(solution.isIsomorphic("paper", "title"));

    }

    public class Solution {
        /**
         * @param s a string
         * @param t a string
         *
         * @return true if the characters in s can be replaced to get t or false
         */
        public boolean isIsomorphic(String s, String t) {
            // Write your code here
            if (s == null || t == null) {
                return false;
            }
            int length = s.length();
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    if (map.get(s.charAt(i)) != t.charAt(i)) {
                        return false;
                    }
                }
            }

            Map<Character, Character> map1 = new HashMap<>();
            for (int i = 0; i < length; i++) {
                if (!map1.containsKey(t.charAt(i))) {
                    map1.put(t.charAt(i), s.charAt(i));
                } else {
                    if (map1.get(t.charAt(i)) != s.charAt(i)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
