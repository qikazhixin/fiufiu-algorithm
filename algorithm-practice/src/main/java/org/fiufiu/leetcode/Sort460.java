package org.fiufiu.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Like Liu
 * @description 最不经常使用（LFU）
 * @since Oracle JDK1.8
 **/
public class Sort460 {

    private Map<Integer, Integer> map;
    private int size;
    private int now=0;

    public Sort460(int capacity) {
        map = new HashMap<>(capacity*2);
        size = capacity;
    }

    public int get(int key) {
        return map.get(key);
    }

    public void put(int key, int value) {
        if (now == size) {
            //移除

        } else {
            map.put(key, value);
            now++;
        }
    }

}
