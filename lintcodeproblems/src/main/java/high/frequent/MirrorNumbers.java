package high.frequent;

/**
 * Created by chenj240 on 9/20/17.
 * A mirror number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is mirror. The number is represented as a string.
 * Example
 * For example, the numbers "69", "88", and "818" are all mirror numbers.
 * Given num = "69" return true
 * Given num = "68" return false
 * 96801866799810896
 */

public class MirrorNumbers {
    public static void main(String[] args) {
        Solution solution = new MirrorNumbers().new Solution();
        System.out.print(solution.isStrobogrammatic("44"));
    }

    public class Solution {
        /*
         * @param num: a string
         * @return: true if a number is strobogrammatic or false
         */
        public boolean isStrobogrammatic(String num) {
            // write your code here

            int[] map = new int[256];
            map['0'] = '0';
            map['1'] = '1';
            map['6'] = '9';
            map['8'] = '8';
            map['9'] = '6';
            for (int i = 0; i < num.length(); i++) {
                int j = num.length() - i - 1;
                int a = map[num.charAt(i)];
                int b = num.charAt(j);
                if (a != b) {
                    return false;
                }
            }
            return true;
//            if (num == null) {
//                return false;
//            }
//            if (num.length() == 0) {
//                return true;
//            }
//            if (num.length() == 1) {
//                if (num.charAt(0) == '8'||num.charAt(0) == '1'||num.charAt(0) == '0'){
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//            char[] source = num.toCharArray();
//            char[] reverse = new char[num.length()];
//            for (int i = 0; i < num.length(); i++) {
//                reverse[i] = source[source.length - 1 - i];
//            }
//
//            if (num.length()%2==1){
//                if (num.charAt(num.length()/2) != '1'&&num.charAt(num.length()/2) != '8'&& num.charAt(num.length()/2) != '0'){
//                    return false;
//                }
//            }
//
//            for (int i = 0; i < num.length(); i++) {
//                if (((reverse[i] != '9') && (reverse[i] != '6') && reverse[i] == source[i])
//                        || (reverse[i] == '6' && source[i] == '9')
//                        || (reverse[i] == '9' && source[i] == '6')) {
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//            return true;
        }
    }
}
