package high.frequent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenj240 on 9/20/17.
 * Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.
 * <p>
 * Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 * If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character
 * until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 * If the abbreviation doesn't make the word shorter, then keep it as original.
 * Notice
 * <p>
 * Both n and the length of each word will not exceed 400.
 * The length of each word is greater than 1.
 * The words consist of lowercase English letters only.
 * The return answers should be in the same order as the original array.
 * Example
 * Given dict = ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 * return ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 */

public class WordsAbbreviation {
    public static void main(String[] args) {
        String[] dict = new String[] {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        Solution solution = new WordsAbbreviation().new Solution();
        String[] result = solution.wordsAbbreviation(dict);
        for (String item : result) {
            System.out.print(item + " ");
        }
    }

    public class Solution {
        /*
         * @param dict: an array of n distinct non-empty strings
         * @return: an array of minimal possible abbreviations for every word
         */
        public String[] wordsAbbreviation(String[] dict) {
            // write your code here
            String[] result = new String[dict.length];
            if (dict == null || dict.length == 0) {
                return result;
            }
            Map<String, Integer> hashMap = new HashMap<>();
            int[] prefix = new int[dict.length];
            for (int i = 0; i < dict.length; i++) {
                result[i] = getAbbreviation(dict[i], 1, dict[i].length());
                prefix[i] = 1;
                if (hashMap.containsKey(result[i])) {
                    hashMap.put(result[i], hashMap.get(result[i]) + 1);
                } else {
                    hashMap.put(result[i], 1);
                }
            }

            while (true) {
                boolean isUnique = true;
                for (int i = 0; i < dict.length; i++) {
                    if (hashMap.get(result[i]) > 1) {
                        prefix[i]++;
                        result[i] = getAbbreviation(dict[i], prefix[i], dict[i].length());
                        if (hashMap.containsKey(result[i])) {
                            hashMap.put(result[i], hashMap.get(result[i]) + 1);
                        } else {
                            hashMap.put(result[i], 1);
                        }
                        isUnique = false;
                    }
                }
                if (isUnique) {
                    break;
                }
            }

            return result;
        }

        private String getAbbreviation(String s, int index, int length) {
            if (index >= length - 2) {
                return s;
            }
            return s.substring(0, index) + (length - 1 - index) + s.charAt(length - 1);
        }


    }
}
