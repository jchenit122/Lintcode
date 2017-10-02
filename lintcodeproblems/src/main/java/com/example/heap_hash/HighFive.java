package com.example.heap_hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenj240 on 9/7/17.
 * There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5
 * highest scores for each person.
 * <p>
 * Example
 * Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
 * Return
 */

public class HighFive {
    public static void main(String[] args) {
        Record[] results = new Record[] {new Record(1, 91), new Record(1, 92), new Record(2, 93), new Record(2, 99),
                new Record(2, 98), new Record(2, 97), new Record(1, 60), new Record(1, 58), new Record(2, 100), new Record(1, 61)};
        Solution solution = new HighFive().new Solution();
        Map<Integer, Double> map = solution.highFive(results);
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public class Solution {
        /**
         * @param results a list of <student_id, score>
         *
         * @return find the average of 5 highest scores for each person
         * Map<Integer, Double> (student_id, average_score)
         */
        public Map<Integer, Double> highFive(Record[] results) {
            // Write your code here
            Map<Integer, Double> resultMap = new HashMap<>();

            if (results == null || results.length == 0) {
                return resultMap;
            }

            Map<Integer, Queue<Integer>> queueMap = new HashMap<>();
            for (int i = 0; i < results.length; i++) {
                if (queueMap.containsKey(results[i].id)) {
                    queueMap.get(results[i].id).add(results[i].score);
                    if (queueMap.get(results[i].id).size() > 5) {
                        queueMap.get(results[i].id).poll();
                    }
                } else {
                    Queue<Integer> queue = new PriorityQueue<>();
                    queue.add(results[i].score);
                    queueMap.put(results[i].id, queue);
                }
            }

            for (Map.Entry<Integer, Queue<Integer>> entry : queueMap.entrySet()) {
                Queue<Integer> queue = entry.getValue();
                int sum = 0;
                while (!queue.isEmpty()) {
                    sum += queue.poll();
                }
                double average = sum / 5.0;
                resultMap.put(entry.getKey(), average);
            }

            return resultMap;
        }
    }
}
