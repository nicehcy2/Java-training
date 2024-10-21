package org.example.collections;

import java.util.*;

public class Question03 {

    Map<String, Integer> map;

    public Question03() {

        this.map = new HashMap<>();
        map.put("김열공", 80);
        map.put("최고봉", 90);
        map.put("우등생", 95);
        map.put("나자바", 88);
    }

    Integer getScore(String name) {

        return map.get(name);
    }
}
