package com.example.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 8/21/17.
 */

public class CloneGraph {

    public static void main(String[] args) {
        UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        zero.neighbors = new ArrayList<>(Arrays.asList(one, two));
        one.neighbors = new ArrayList<>(Arrays.asList(two));
        two.neighbors = new ArrayList<>(Arrays.asList(two));

        UndirectedGraphNode zeroOne = new UndirectedGraphNode(0);
        zeroOne.neighbors = new ArrayList<>(Arrays.asList(zeroOne, zeroOne));

        Solution solution = new CloneGraph().new Solution();

        System.out.print(solution.cloneGraph(zero).label);
        System.out.print(solution.cloneGraph(zeroOne).label);

    }

    public class Solution {
        /**
         * @param node: A undirected graph node
         *
         * @return: A undirected graph node
         */
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            // write your code here
            if (node == null) {
                return null;
            }

            // get all nodes
            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            Set<UndirectedGraphNode> set = new HashSet<>();
            queue.add(node);
            set.add(node);
            while (!queue.isEmpty()) {
                UndirectedGraphNode undirectedGraphNode = queue.poll();
                for (UndirectedGraphNode graphNode : undirectedGraphNode.neighbors) {
                    if (!set.contains(graphNode)) {
                        queue.add(graphNode);
                        set.add(graphNode);
                    }
                }
            }

            // copy nodes
            Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
            for (UndirectedGraphNode nodeInSet : set) { map.put(nodeInSet, new UndirectedGraphNode(nodeInSet.label)); }

            // get neighbors

            for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
                ArrayList<UndirectedGraphNode> nodeArrayList = new ArrayList<>();
                for (UndirectedGraphNode neighbor : entry.getKey().neighbors) {
                    nodeArrayList.add(map.get(neighbor));
                }
                entry.getValue().neighbors = nodeArrayList;
            }
            return map.get(node);
        }
    }
}
