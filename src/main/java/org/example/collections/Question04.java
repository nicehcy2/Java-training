package org.example.collections;

import java.util.*;

public class Question04 {

    private Set<String> a1 = new HashSet<>();
    private TreeSet<String> a2;

    public Question04() {
        this.a1.addAll(Arrays.asList("독수리", "나비", "염소", "고양이", "개미", "여우"));
        this.a1.addAll(Arrays.asList("개", "쿼카", "코끼리", "토끼", "돼지", "늑대"));

        this.a2 = new TreeSet<>(this.a1);
    }

    public Set<String> getA1() {
        return a1;
    }

    public TreeSet<String> getA2() {
        return a2;
    }
}
