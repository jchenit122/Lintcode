package high.frequent;

/**
 * Created by chenj240 on 9/27/17.
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity
 * is that all the other n - 1 people know him/her but he/she does not know any of them.
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like:
 * "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as
 * few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function
 * should minimize the number of calls to knows.
 * Notice
 * There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 * Example
 * Given n = 2
 * 2 // next n * (n - 1) lines
 * 0 knows 1
 * 1 does not know 0
 * return 1 // 1 is celebrity
 */

public class IdentifyCelebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    public class Solution {
        /**
         * @param n a party with n people
         *
         * @return the celebrity's label or -1
         */
        public int findCelebrity(int n) {
            // Write your code here
            int ans =0;
//            for (int i =1;i<n;i++){
//                if (knows(ans,i)){
//                    ans =i;
//                }
//            }
		int s = 89;
//            for (int i =0;i<n;i++){
//                if(i!=ans && knows(ans,i)){
//                    return -1;
//                }
//                if(i!=ans && !knows(i,ans)){
//                    return -1;
//                }
//            }
            return ans;
        }
    }
}
