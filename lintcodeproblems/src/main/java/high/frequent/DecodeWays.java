package high.frequent;

/**
 * Created by chenj240 on 9/19/17.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * Example
 * Given encoded message 12, it could be decoded as AB (1 2) or L (12).
 * The number of ways decoding 12 is 2.
 */

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        System.out.print(solution.numDecodings("5005"));
        System.out.print(solution.numDecodings("54120"));
        System.out.print(solution.numDecodings("12"));
        System.out.print(solution.numDecodings("192611"));
        System.out.print(solution.numDecodings("19261001"));
        System.out.print(solution.numDecodings("2789011203"));

    }

    public class Solution {
        /*
         * @param s: a string,  encoded message
         * @return: an integer, the number of ways decoding
         */
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int length = s.length();
            int[] f = new int[length + 1];
            char[] source = s.toCharArray();
            f[0] = 1;
            for (int i = 1; i <= length; i++) {
                if ((source[i - 1]-'0') != 0) {
                    f[i] += f[i - 1];
                }
                if (i >= 2) {
                    int value = (source[i - 2] -'0') * 10+ source[i - 1] - '0';
                    if (value >= 10 && value <= 26) {
                        f[i] += f[i - 2];
                    }
                }
            }
            return f[length];
            // write your code here

            //            if (s == null || s.length() == 0) {
            //                return 0;
            //            }
            //
            //            if (Character.getNumericValue(s.charAt(0)) == 0) {
            //                return 0;
            //            }
            //
            //            char[] source = s.toCharArray();
            //            int[] f = new int[s.length()+1];
            //            f[0] = 1;
            //            f[1] = 1;
            //            for (int i = 2; i <= source.length; i++) {
            //                if(i <= source.length && Character.getNumericValue(source[i-1]) == 0 && i <= source.length && Character.getNumericValue
            //                        (source[i-2]) == 0){
            //                    return 0;
            //                }
            //                if(i <= source.length && Character.getNumericValue(source[i-1]) == 0 && Character.getNumericValue
            //                        (source[i-2])*10 +Character.getNumericValue(source[i-1]) > 20){
            //                    return 0;
            //                }
            //                if (Character.getNumericValue(source[i-1]) + Character.getNumericValue(source[i - 2]) * 10 > 10
            //                        && Character.getNumericValue(source[i-1]) + Character.getNumericValue(source[i - 2]) * 10 <= 26) {
            //
            //                    if (i + 1 <= source.length && Character.getNumericValue(source[i]) == 0 || i <= source.length && Character
            // .getNumericValue
            //                            (source[i-1]) == 0) {
            //                        f[i] = f[i - 1];
            //                    } else {
            //                        f[i] = f[i - 1] + f[i-2];
            //                    }
            //                } else {
            //                    f[i] = f[i - 1];
            //                }
            //            }
            //            return f[source.length ];
        }
    }
}
