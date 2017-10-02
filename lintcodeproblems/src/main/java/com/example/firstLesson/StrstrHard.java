package com.example.firstLesson;

/**
 * Created by chenj240 on 7/31/17.
 * Implement strStr function in O(n + m) time.
 */

public class StrstrHard {

    private static final int BASE = 1000000;
    private static final int HASH_MAGIC_NUM = 31;

    public static void main(String[] args) {

        String source = "bcdabcdefg";
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

        int m =target.length();
        if (m == 0) {
            return 0;
        }

        int power =1 ;

        for (int i =0; i<m;i++){
            power = (power*HASH_MAGIC_NUM)%BASE;
        }

        // target code
        int targetCode = 0;
        for ( int i = 0 ; i < m; i++){
            targetCode = (targetCode * HASH_MAGIC_NUM + target.charAt(i)) % BASE;
        }

        // source hash code
        int sourceCode = 0;
        for ( int i = 0 ; i < source.length(); i++){
            sourceCode = (sourceCode * HASH_MAGIC_NUM + source.charAt(i)) % BASE;
            // ab+c
            if (i<m-1){
                continue;
            }

            // abcd - d
            if (i>=m){
                sourceCode = sourceCode - (source.charAt(i - m) * power) % BASE;
                if (sourceCode<=0){
                    sourceCode = sourceCode+ BASE;
                }
            }

            if (targetCode == sourceCode && source.substring(i-m+1, i+1).equals(target)){
                return i -m +1;
            }
        }

        return -1;
    }
}
