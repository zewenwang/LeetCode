package com.michael.algorithms.others;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Copy. using LinkedHashMap: it will change the order when call get() method
 * <p/>
 * Created by michael on 15/5/30.
 * <p/>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache3 {

    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache3(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 1, true); //set access order to true
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        return map.get(key);
    }

    public void set(int key, int value) {
        if (!map.containsKey(key) && (map.size() == capacity)) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache3 lruCache = new LRUCache3(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
