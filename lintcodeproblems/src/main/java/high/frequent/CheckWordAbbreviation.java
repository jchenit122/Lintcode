package high.frequent;

/**
 * Created by chenj240 on 9/19/17.
 * Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation.
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice
 * Notice that only the above abbreviations are valid abbreviations of the string word. Any other string is not a valid abbreviation of word.
 * Example
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * Return false.
 */

public class CheckWordAbbreviation {
    public static void main(String[] args) {
        Solution solution = new CheckWordAbbreviation().new Solution();
        //System.out.print(solution.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.print(solution.validWordAbbreviation("a", "01"));
    }

    public class Solution {
        /*
         * @param word: a non-empty string
         * @param abbr: an abbreviation
         * @return: true if string matches with the given abbr or false
         */
        public boolean validWordAbbreviation(String word, String abbr) {
            // write your code here
            if (word == null || abbr == null) {
                return false;
            }

            int index=0;
            for (int i = 0; i < abbr.length();) {
                int num = 0;
                if (Character.isDigit(abbr.charAt(i))) {
                    if (Character.getNumericValue(abbr.charAt(i)) ==0){
                        return false;
                    }
                    while ( i<abbr.length() && Character.isDigit(abbr.charAt(i))) {
                        num = num * 10 + Character.getNumericValue(abbr.charAt(i));
                        i++;
                    }
                    if (index + num >word.length()){
                        return false;
                    }else {
                        index= index+num;
                    }
                } else {
                    if (word.charAt(index) == abbr.charAt(i)) {
                        index++;
                        i++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
