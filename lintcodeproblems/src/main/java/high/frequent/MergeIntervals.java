package high.frequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chenj240 on 10/2/17.
 * Given a collection of intervals, merge all overlapping intervals.
 * Example
 * Given intervals => merged intervals:
 * [                     [
 * [1, 3],               [1, 6],
 * [2, 6],      =>       [8, 10],
 * [8, 10],              [15, 18]
 * [15, 18]            ]
 * ]
 * Challenge
 * O(n log n) time and O(1) extra space.
 */

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        List<Interval> testList = new ArrayList<>();
        Interval one = new Interval(1,3);
        Interval two = new Interval(2,6);
        Interval three = new Interval(8,10);
        Interval four = new Interval(15,18);
        testList.add(one);
        testList.add(three);
        testList.add(two);
        testList.add(four);
        List<Interval> intervals = solution.merge(testList);
        for (Interval interval : intervals) {
            System.out.println(interval.start + " -> " + interval.end);
        }
    }

    public class Solution {
        /*
         * @param intervals: interval list.
         * @return: A new interval list.
         */
        public List<Interval> merge(List<Interval> intervals) {
            // write your code here
            List<Interval> result = new ArrayList<>();

            if (intervals == null || intervals.size()==0){
                return result;
            }

            Comparator<Interval> comparator = new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    return i1.start-i2.start;
                }
            };

            Collections.sort(intervals,comparator);
            return result;

        }
    }
}
