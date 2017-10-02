package com.example.BFS;

import java.util.ArrayList;

/**
 * Created by chenj240 on 8/17/17.
 */

public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
