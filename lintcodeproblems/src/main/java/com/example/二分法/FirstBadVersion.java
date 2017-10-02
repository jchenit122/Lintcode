package com.example.二分法;

/**
 * Created by chenj240 on 8/9/17.
 */

public class FirstBadVersion {

    /**
     * @param n: An integers.
     *
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here

        int start=1, end =n;
        while (start+1<end){
            int mid = start+(end -start)/2;
            if (SVNRepo.isBadVersion(mid)){
                end =mid;
            }else {
                start =mid;
            }

        }

        if (SVNRepo.isBadVersion(start)){
            return start;
        }
        if (SVNRepo.isBadVersion(end)){
            return end;
        }
        return -1;
    }

    private static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return true;
        }
    }
}
