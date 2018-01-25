package com.michael.algorithms.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * using LinkedList , Time Limit Exceeded
 * <p/>
 * Created by michael on 15/5/30.
 * <p/>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache2 {
    public Map<Integer, Integer> cache = null;
    public List<Integer> keyList = null;
    public int capacity;

    public LRUCache2(int capacity) {
        cache = new HashMap<Integer, Integer>();
        keyList = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer val = cache.get(key);
        if (val == null)
            return -1;
        keyList.remove(new Integer(key));
        keyList.add(key);
        return val;
    }

    public void set(int key, int value) {
//        cache.put(key, value);
//        keyList.add(key);
//        if (cache.size() > capacity) {
//            int leastKey = keyList.remove(0);
//            cache.remove(leastKey);
//        }


        int val = get(key);
        cache.put(key, value);
        if (val == -1) {
            keyList.add(key);
            if (keyList.size() > capacity) {
                int tmp = keyList.get(0);
                keyList.remove(0);
                cache.remove(tmp);
            }
        }
    }

//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.set(2, 1);
//        lruCache.set(1, 1);
//        System.out.println(lruCache.get(2));
//        lruCache.set(4, 1);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//    }
}
