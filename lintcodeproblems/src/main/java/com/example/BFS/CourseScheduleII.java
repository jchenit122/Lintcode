package com.example.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by chenj240 on 8/17/17.
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */

public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] prerequisitePairs = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int n = 4;
        Solution solution = new CourseScheduleII().new Solution();
        System.out.println(Arrays.toString(solution.findOrder(n, prerequisitePairs)));

        int[][] prerequisitePairsOne = {{1, 0}};
        int nOne = 2;
        Solution solutionOne = new CourseScheduleII().new Solution();
        System.out.println(Arrays.toString(solutionOne.findOrder(nOne, prerequisitePairsOne)));

        int[][] prerequisitePairstwo = {{1, 0}, {0, 1}};
        int nTwo = 2;
        Solution solutionTwo = new CourseScheduleII().new Solution();
        System.out.println(Arrays.toString(solutionTwo.findOrder(nTwo, prerequisitePairstwo)));

        int[][] prerequisitePairsThree = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        int nThree = 10;
        Solution solutionThree = new CourseScheduleII().new Solution();
        System.out.println(Arrays.toString(solutionThree.findOrder(nThree, prerequisitePairsThree)));

        int[][] prerequisitePairsFour = new int[0][0];
        int nFour = 1;
        Solution solutionFour = new CourseScheduleII().new Solution();
        System.out.println(Arrays.toString(solutionFour.findOrder(nFour, prerequisitePairsFour)));
    }

    public class Solution {
        /**
         * @param numCourses    a total of n courses
         * @param prerequisites a list of prerequisite pairs
         *
         * @return the course order
         */
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // Write your code here
            int[] result = new int[0];
            ArrayList<Integer> rs = new ArrayList<>();

            if (prerequisites == null || numCourses == 0) {
                return result;
            }

            // 1. count indegree
            Map<Integer, Integer> indegree = new HashMap<>();
            Map<Integer, ArrayList<Integer>> prerequisitePair = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                indegree.put(i, 0);
            }
            for (int i = 0; i < numCourses; i++) {
                prerequisitePair.put(i, new ArrayList<Integer>());
            }
            int deltaY = 0;
            for (int i = 0; i < prerequisites.length; i++) {
                indegree.put(prerequisites[i][deltaY], indegree.get(prerequisites[i][deltaY]) + 1);
                prerequisitePair.get(prerequisites[i][1]).add(prerequisites[i][deltaY]);
            }

            // 2. get start nodes
            Queue<Integer> queue = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
                if (entry.getValue() == 0) {
                    queue.add(entry.getKey());
                    rs.add(entry.getKey());
                }
            }

            // 3. bfs
            //version One
            //            while (!queue.isEmpty()) {
            //                int course = queue.poll();
            //                for (int i = 0; i < prerequisites.length; i++) {
            //                    if (prerequisites[i][1] == course) {
            //                        indegree.put(prerequisites[i][deltaY], indegree.get(prerequisites[i][deltaY]) - 1);
            //                        if (indegree.get(prerequisites[i][deltaY]) == 0) {
            //                            queue.add(prerequisites[i][deltaY]);
            //                            rs.add(prerequisites[i][deltaY]);
            //                        }
            //                    }
            //                }
            //            }

            while (!queue.isEmpty()) {
                int course = queue.poll();
                int size = prerequisitePair.get(course).size();
                for (int i = 0; i < size; i++) {
                    indegree.put(prerequisitePair.get(course).get(i), indegree.get(prerequisitePair.get(course).get(i)) - 1);
                    if (indegree.get(prerequisitePair.get(course).get(i)) == 0) {
                        queue.add(prerequisitePair.get(course).get(i));
                        rs.add(prerequisitePair.get(course).get(i));
                    }
                }
            }

            if (rs.size() == numCourses) {
                result = new int[numCourses];
                for (int i = 0; i < numCourses; i++) {
                    result[i] = rs.get(i);
                }
                return result;
            }

            return result;
        }
    }
}
