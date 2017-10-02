package high.frequent;

/**
 * Created by chenj240 on 9/28/17.
 * Given a roman numeral, convert it to an integer.
 * The answer is guaranteed to be within the range from 1 to 3999.
 * Clarification
 * What is Roman Numeral?
 * https://en.wikipedia.org/wiki/Roman_numerals
 * https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
 * http://baike.baidu.com/view/42061.htm
 * Example
 * IV -> 4
 * XII -> 12
 * XXI -> 21
 * XCIX -> 99
 */

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        System.out.print(solution.romanToInt("MDCCCLXXXIV"));
    }

    public class Solution {
        /*
         * @param s: Roman representation
         * @return: an integer
         */
        public int romanToInt(String s) {
            // write your code here
            int ans = 0;
            char[] src = s.toCharArray();
            ans += match(src[0]);
            for (int i = 1; i < s.length(); i++) {
                if (match(src[i]) == -1) {
                    return -1;
                }
                ans += match(src[i]);
                if (match(src[i - 1]) < match(src[i])) {
                    ans = ans - 2 * match(src[i - 1]);
                }
            }
            return ans;

        }

        private int match(char s) {
            switch (s) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }
            return -1;
        }
    }
}
