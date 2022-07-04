package com.leetcode.test;

import java.util.*;

/**
 * @Author: Felix
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        /*String str = "\"docID\":\"123\"";
        Map<String, Object> map = new HashMap<>();
        map.put("strMap", str);
        System.out.println(map);

        Deque<Integer> deque = new LinkedList<>();
        deque.pop();
        deque.poll();*/

        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("Name", i);
            map.put("Age", i);
            list.add(map);
        }

        for (Map<String, Object> m : list) {
            for (String s : m.keySet()) {
                System.out.println(s + ":" + m.get(s));
            }
        }
    }
}
