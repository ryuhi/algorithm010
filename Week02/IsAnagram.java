package com.ryuhi.execute.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (null ==s || s.length() == 0) {
            return false;
        }
        if (null ==t || t.length() == 0) {
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> maps = new HashMap<>(s.length());
        for (String s1 : s.split("")) {
            maps.put(s1, maps.getOrDefault(s1, 0) + 1);
        }
        Map<String, Integer> mapt = new HashMap<>(t.length());
        for (String t1 : t.split("")) {
            mapt.put(t1, mapt.getOrDefault(t1, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            if (!mapt.containsKey(key) || mapt.get(key) != count) {
                return false;
            }
        }
        return true;
    }
}
