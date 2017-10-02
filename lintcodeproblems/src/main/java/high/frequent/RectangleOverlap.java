package high.frequent;

import com.example.heap_hash.Point;

/**
 * Created by chenj240 on 9/18/17.
 * Given two rectangles, find if the given two rectangles overlap or not.
 * Notice
 * l1: Top Left coordinate of first rectangle.
 * r1: Bottom Right coordinate of first rectangle.
 * l2: Top Left coordinate of second rectangle.
 * r2: Bottom Right coordinate of second rectangle.
 * l1 != r2 and l2 != r2
 * Example
 * Given l1 = [0, 8], r1 = [8, 0], l2 = [6, 6], r2 = [10, 0], return true
 * Given l1 = [0, 8], r1 = [8, 0], l2 = [9, 6], r2 = [10, 0], return `false
 */

public class RectangleOverlap {
    public static void main(String[] args) {
        Point l1 = new Point(0,8);
        Point r1 = new Point(8,0);
        Point l2 = new Point(9,6);
        Point r2 = new Point(10,0);
        Solution solution = new RectangleOverlap().new Solution();
        System.out.print(solution.doOverlap(l1,r1,l2,r2));
    }
        public class Solution {
        /*
         * @param l1: top-left coordinate of first rectangle
         * @param r1: bottom-right coordinate of first rectangle
         * @param l2: top-left coordinate of second rectangle
         * @param r2: bottom-right coordinate of second rectangle
         * @return: true if they are overlap or false
         */
        public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
            // write your code here
            if (l1 == null || r1 == null || l2 == null|| r2==null){
                return false;
            }

            if (r1.x < l2.x || l1.x > r2.x){
                return false;
            }

            if (l1.y < r2.y || r1.y > l2.y){
                return false;
            }
            return true;
        }
    }
}
