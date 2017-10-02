package com.example.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 8/21/17.
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */

public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;

        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edgesOne = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        int nTwo =4;
        int[][] edgesTwo = {{1,2},{1,3},{2,3}};
        Solution solution = new GraphValidTree().new Solution();
        System.out.println(solution.validTree(n, edges));
        System.out.println(solution.validTree(n, edgesOne));
        System.out.print(solution.validTree(nTwo, edgesTwo));

    }

    public class Solution {
        /**
         * @param n     an integer
         * @param edges a list of undirected edges
         *
         * @return true if it's a valid tree, or false
         */
        public boolean validTree(int n, int[][] edges) {
            // Write your code here

            if (n ==0|| edges ==null){
                return false;
            }

            if (n==1){
                return true;
            }

            // n nodes, n-1 edges
            if (edges.length != n-1){
                return false;
            }
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
             queue.add(edges[0][0]);
            set.add(edges[0][0]);
            while (!queue.isEmpty()){
                int node = queue.poll();
                for (int i=0;i<edges.length;i++){
                    if (edges[i][0]==node){
                        if (!set.contains(edges[i][1])){
                            set.add(edges[i][1]);
                            queue.add(edges[i][1]);
                        }
                    }

                    if (edges[i][1]==node){
                        if (!set.contains(edges[i][0])){
                            set.add(edges[i][0]);
                            queue.add(edges[i][0]);
                        }
                    }
                }
            }
            if (set.size() ==n){
                return true;
            }
            return false;
        }
    }
}
