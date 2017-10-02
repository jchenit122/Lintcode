package com.example.GoogleInterviews;

/**
 * Created by chenj240 on 9/6/17.
 * Given an integer, convert it to a roman numeral.
 * The number is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Clarification
 * What is Roman Numeral?
 * https://en.wikipedia.org/wiki/Roman_numerals
 * https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
 * http://baike.baidu.com/view/42061.htm
 * Example
 * 4 -> IV
 * 12 -> XII
 * 21 -> XXI
 * 99 -> XCIX
 * more examples at: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
 * Symbol	I	V	X	L	C	D	M
 * Value	1	5	10	50	100	500	1,000
 */

public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        System.out.print(solution.intToRoman(11));
    }

    public class Solution {
        /*
         * @param n: The integer
         * @return: Roman representation
         */
        public String intToRoman(int num) {
            // write your code here
            if (num <= 0) {
                return "";
            }
            StringBuilder result = new StringBuilder();
            int[] integerArray = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int digit = 0;
            while (num > 0) {
                int times = num / integerArray[digit];
                num -= integerArray[digit] * times;
                for (; times > 0; times--) {
                    result.append(symbol[digit]);
                }
                digit++;
            }

            return result.toString();
        }
    }
}
