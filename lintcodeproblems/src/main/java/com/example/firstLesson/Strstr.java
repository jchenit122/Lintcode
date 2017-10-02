package com.example.firstLesson;

/**
 * Created by chenj240 on 7/25/17.
 */

public class Strstr {
    public static void main(String[] args) {

        String source = "abcdabcdefg";
        String target = "bcd";

        String sourceOne = "source";
        String targetOne = "target";

        String sourceTwo = "tartarget";
        String targetTwo = "target";

        System.out.println(strStr(source, target));
        System.out.println(strStr(sourceOne, targetOne));
        System.out.println(strStr(sourceTwo, targetTwo));

    }

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        // write your code here

        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }

        for (int i = 0; i < source.length(); i++) {
            int z = i;
            for (int j = 0; j < target.length() && z < source.length(); j++) {
                if (source.charAt(z) != target.charAt(j)) {
                    break;
                } else {
                    z += 1;
                }
                if (j == target.length() - 1) {
                    return z - target.length();
                }
            }
        }
        return -1;
    }
}
