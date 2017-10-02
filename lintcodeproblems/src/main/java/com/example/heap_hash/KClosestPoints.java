package com.example.heap_hash;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenj240 on 9/7/17.
 * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
 * <p>
 * Example
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 */

public class KClosestPoints {
    public static void main(String[] args) {
        Point[] points = new Point[] {new Point(4, 6), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)};
        Point origin = new Point();
        Solution solution = new KClosestPoints().new Solution();
        Point[] results = solution.kClosest(points, origin, 3);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i].x + ", " + results[i].y);
        }
    }

    public class Solution {
        /*
         * @param points: a list of points
         * @param origin: a point
         * @param k: An integer
         * @return: the k closest points
         */
        public Point[] kClosest(Point[] points, Point origin, int k) {
            // write your code here
            Point[] result = new Point[k];
            if (points == null || points.length == 0 || k == 0 || origin == null) {
                return result;
            }

            Queue<Pair> queue = new PriorityQueue<>(10, new Comparator<Pair>() {
                @Override
                public int compare(Pair t1, Pair t2) {
                    if (t1.distance != t2.distance) {
                        return t1.distance - t2.distance;
                    } else if (t1.point.x != t2.point.x) {
                        return t1.point.x - t2.point.x;
                    } else {
                        return t1.point.y - t2.point.y;
                    }
                }
            });
            for (int i = 0; i < points.length; i++) {
                queue.add(new Pair(points[i], (points[i].x - origin.x) * (points[i].x - origin.x) + (points[i].y - origin.y) * (points[i].y -
                        origin.y)));
            }

            for (int i = 0; i < k; i++) {
                result[i] = queue.poll().point;
            }

            return result;
        }

        class Pair {
            Point point;
            int distance;

            Pair(Point point, int distance) {
                this.point = point;
                this.distance = distance;
            }
        }
    }
}
