package high.frequent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenj240 on 9/27/17.
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the
 * original list of strings.
 * Please implement encode and decode
 * Example
 * Given strs = ["lint","code","love","you"]
 * string encoded_string = encode(strs)
 * return `["lint","code","love","you"]｀ when you call decode(encoded_string)
 */

public class StringsSerialization {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("lint");
        input.add("code");
        input.add("lovehhhhhhhhhhhh");
        input.add("you");
        Solution solution = new StringsSerialization().new Solution();
        String encodedString = solution.encode(input);
        System.out.println(encodedString);
        for (String entry : solution.decode(encodedString)) {
            System.out.println(entry);
        }
    }

    public class Solution {
        /*
         * @param strs: a list of strings
         * @return: encodes a list of strings to a single string.
         */
        public String encode(List<String> strs) {
            // write your code here
            String encoded = "";
            for (String entry : strs) {
                encoded += entry.length()+"$" + entry;
            }
            return encoded;
        }

        /*
         * @param str: A string
         * @return: dcodes a single string to a list of strings
         */
        public List<String> decode(String str) {
            // write your code here
            List<String> result = new ArrayList<>();
            int i = 0;
            while (i < str.length()) {
                int index = str.indexOf('$',i);
                int length = Integer.parseInt(str.substring(i,index));
                result.add(str.substring(index+1,index+length+1));
                i = index+length + 1;
            }

            return result;
        }
    }
}
