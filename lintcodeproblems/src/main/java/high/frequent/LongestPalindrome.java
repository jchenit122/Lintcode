package high.frequent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenj240 on 9/21/17.
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Notice
 * Assume the length of given string will not exceed 1010.
 * Example
 * Given s = "abccccdd" return 7
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.print(solution.longestPalindrome("abccccdd"));
    }
        public class Solution {
        /*
         * @param s: a string which consists of lowercase or uppercase letters
         * @return: the length of the longest palindromes that can be built
         */
        public int longestPalindrome(String s) {
            // write your code here
            if (s == null || s.length()==0){
                return 0;
            }
            char[] souce = s.toCharArray();
            Set<Character> set = new HashSet<>();
            for (int i= 0;i<souce.length;i++){
                if (set.contains(souce[i])){
                    set.remove(souce[i]);
                }else {
                    set.add(souce[i]);
                }
            }
            if (set.size()==0){
                return souce.length;
            }
            return souce.length-set.size()+1;
        }
    }
}
