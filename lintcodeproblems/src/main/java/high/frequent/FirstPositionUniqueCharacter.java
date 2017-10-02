package high.frequent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenj240 on 9/30/17.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Example
 * Given s = "lintcode", return 0.
 * Given s = "lovelintcode", return 2.
 */

public class FirstPositionUniqueCharacter {
    public static void main(String[] args) {
        Solution solution = new FirstPositionUniqueCharacter().new Solution();
        System.out.println(solution.firstUniqChar("lintcode"));
        System.out.println(solution.firstUniqChar("lovelintcode"));

    }

    public class Solution {
        /*
         * @param s: a string
         * @return: it's index
         */
        public int firstUniqChar(String s) {
            // write your code here
            if (s == null || s.length() == 0) {
                return -1;
            }
            Map<Character, Integer> map = new HashMap();

            char[] source = s.toCharArray();

            for (char c : source) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            for (int i=0;i<source.length;i++){
                if (map.get(source[i])==1){
                    return i;
                }
            }
            return -1;

        }
    }

}
