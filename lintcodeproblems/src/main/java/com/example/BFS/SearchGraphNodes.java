package com.example.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 8/17/17.
 * Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target, return NULL if you can't find.
 * There is a mapping store the nodes' values in the given parameters.
 */

public class SearchGraphNodes {

    public static void main(String[] args) {

        UndirectedGraphNode noteOne = new UndirectedGraphNode(3);
        UndirectedGraphNode noteTwo = new UndirectedGraphNode(4);
        UndirectedGraphNode noteThree = new UndirectedGraphNode(10);
        UndirectedGraphNode noteFour = new UndirectedGraphNode(50);
        UndirectedGraphNode noteFive = new UndirectedGraphNode(50);

        ArrayList<UndirectedGraphNode> noteOneNeighbors = new ArrayList<>();
        noteOneNeighbors.add(noteTwo);
        noteOneNeighbors.add(noteThree);
        noteOneNeighbors.add(noteFour);
        noteOne.neighbors = noteOneNeighbors;

        ArrayList<UndirectedGraphNode> noteTwoNeighbors = new ArrayList<>();
        noteTwoNeighbors.add(noteOne);
        noteTwoNeighbors.add(noteThree);
        noteTwo.neighbors = noteTwoNeighbors;

        ArrayList<UndirectedGraphNode> noteThreeNeighbors = new ArrayList<>();
        noteThreeNeighbors.add(noteTwo);
        noteThreeNeighbors.add(noteOne);
        noteThree.neighbors = noteThreeNeighbors;

        ArrayList<UndirectedGraphNode> noteFourNeighbors = new ArrayList<>();
        noteFourNeighbors.add(noteOne);
        noteFourNeighbors.add(noteFive);
        noteFour.neighbors = noteFourNeighbors;

        ArrayList<UndirectedGraphNode> noteFiveNeighbors = new ArrayList<>();
        noteFiveNeighbors.add(noteFour);
        noteFive.neighbors = noteFiveNeighbors;

        ArrayList<UndirectedGraphNode> graph = new ArrayList<>();
        graph.add(noteOne);
        graph.add(noteTwo);
        graph.add(noteThree);
        graph.add(noteFour);
        graph.add(noteFive);

        Map<UndirectedGraphNode, Integer> values = new HashMap<>();
        values.put(noteOne, 3);
        values.put(noteTwo, 4);
        values.put(noteThree, 10);
        values.put(noteFour, 50);
        values.put(noteFive, 50);

        Solution solution = new SearchGraphNodes().new Solution();
        for (UndirectedGraphNode node : solution.searchNode(graph, values, noteOne, 50).neighbors) {
            System.out.println(node.label);
        }
    }


    public class Solution {
        /**
         * @param graph  a list of Undirected graph node
         * @param values a hash mapping, <UndirectedGraphNode, (int)value>
         * @param node   an Undirected graph node
         * @param target an integer
         *
         * @return the a node
         */
        public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                Map<UndirectedGraphNode, Integer> values,
                UndirectedGraphNode node,
                int target) {
            // Write your code here

            if (graph == null || values == null || node == null) {
                return null;
            }

            if (values.get(node)==target){
                return node;
            }

            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            Set<UndirectedGraphNode> set = new HashSet<>();
            queue.add(node);
            set.add(node);
            while (!queue.isEmpty()) {
                UndirectedGraphNode undirectedGraphNode = queue.poll();
                for (UndirectedGraphNode entry : undirectedGraphNode.neighbors) {
                    if (values.get(entry) == target) {
                        return entry;
                    } else if (!set.contains(entry)) {
                        queue.add(entry);
                        set.add(entry);
                    }
                }
            }
            return null;
        }
    }
}
