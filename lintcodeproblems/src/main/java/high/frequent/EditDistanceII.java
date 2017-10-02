package high.frequent;

/**
 * Created by chenj240 on 9/28/17.
 * Given two strings S and T, determine if they are both one edit distance apart.
 * Have you met this question in a real interview? Yes
 * Example
 * Given s = "aDb", t = "adb"
 * return true
 */

public class EditDistanceII {
    public static void main(String[] args) {
        Solution solution = new EditDistanceII().new Solution();
        System.out.print(solution.isOneEditDistance("aDbc", "adb"));
    }

    public class Solution {
        /*
         * @param s: a string
         * @param t: a string
         * @return: true if they are both one edit distance apart or false
         */
        public boolean isOneEditDistance(String s, String t) {
            // write your code here
            if (s.length() > t.length()) {
                return isOneEditDistance(t, s);
            }
            if (t.length() - s.length() > 1) {
                return false;
            }

            if (t.length() - s.length() == 1) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        return s.substring(i, s.length()).equals(t.substring(i + 1, t.length()));
                    }
                }
            }

            if (t.length() == s.length()) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        count++;
                    }
                }
                return count == 1;
            }
            return true;

        }
    }
}
