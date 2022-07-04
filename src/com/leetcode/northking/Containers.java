package com.leetcode.northking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Felix
 * @Description: 集装箱
 */
public class Containers {

    public static int containers(List<List<Integer>> list) {
        //没有集装箱
        if (list.size() == 0) return -1;
        int ans = 1;
        List<Integer> l = new ArrayList<>();
        List<Integer> w = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            l.add(list.get(i).get(0));
            w.add(list.get(i).get(1));
            h.add(list.get(i).get(2));
        }
        while (l.size() != 0) {
            List<Integer> indexs = findIndex(l);
            if (indexs == null) break;
            int min = indexs.get(0), sec = indexs.get(1);
            if (w.get(min) < w.get(sec) && h.get(min) < h.get(sec)) {
                l.remove(min);
                w.remove(min);
                h.remove(min);
            } else {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 查询最小长度
     *
     * @param list 长的列表
     * @return
     */
    public static List<Integer> findIndex(List<Integer> list) {
        if (list.size() == 0) return null;
        if (list.size() == 1) return null;
        Integer minIndex = list.get(0) < list.get(1) ? 0 : 1;
        Integer secIndex = 1 - minIndex;
        int min = list.get(minIndex), sec = list.get(secIndex);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
                minIndex = i;
            } else if (list.get(i) < sec) {
                sec = list.get(i);
                secIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(minIndex);
        ans.add(secIndex);
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> b1 = new ArrayList<Integer>() {{
            add(1);
            add(1);
            add(1);
        }};
        List<Integer> b2 = new ArrayList<Integer>() {{
            add(2);
            add(2);
            add(2);
        }};
        List<Integer> b3 = new ArrayList<Integer>() {{
            add(10);
            add(6);
            add(2);
        }};
        List<Integer> b4 = new ArrayList<Integer>() {{
            add(4);
            add(3);
            add(3);
        }};
        List<List<Integer>> list = new ArrayList<List<Integer>>() {{
            add(b1);
            add(b2);
            add(b3);
            add(b4);
        }};
        System.out.println(containers(list));
    }
}
