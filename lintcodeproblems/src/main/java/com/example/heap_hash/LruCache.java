package com.example.heap_hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenj240 on 9/7/17.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */

public class LruCache {
    public static void main(String[] args) {
        LRUCacheSolution lruCache = new LruCache().new LRUCacheSolution(3);
        lruCache.set(1, 10);
        lruCache.set(2, 20);
        lruCache.set(30, 30);

    }

    public class LRUCacheSolution {

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.pre = null;
                this.next = null;
            }
        }

        private Map<Integer, Node> nodeMap;
        private int capacity;
        private Node dummyHead = new Node(0, 0);
        private Node tail = new Node(0, 0);

        // @param capacity, an integer
        public LRUCacheSolution(int capacity) {
            // write your code here
            this.capacity = capacity;
            this.nodeMap = new HashMap<>();
            this.dummyHead.next = tail;
            this.tail.pre = dummyHead;
        }

        // @return an integer
        public int get(int key) {
            // write your code here
            if (!nodeMap.containsKey(key)) {
                return -1;
            }

            Node current = nodeMap.get(key);
            current.pre.next = current.next;
            current.next.pre = current.pre;

            moveToTail(current);

            return current.value;
        }

        private void moveToTail(Node current) {
           current.pre = tail.pre;
            tail.pre.next = current;
            tail.pre = current;
            current.next = tail;
        }

        // @param key, an integer
        // @param value, an integer
        // @return nothing
        public void set(int key, int value) {
            // write your code here
            if (get(key) != -1) {
                tail.pre.value = value;
                return;
            }
            if (nodeMap.size() == capacity) {
                nodeMap.remove(dummyHead.next.key);
                dummyHead.next = dummyHead.next.next;
                dummyHead.next.pre = dummyHead;
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            moveToTail(newNode);
        }
    }
}
