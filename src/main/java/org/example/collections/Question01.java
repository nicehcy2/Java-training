package org.example.collections;

import java.util.*;

public class Question01 {

    private List<String> list;

    public Question01() {

        list = new ArrayList<>();
        list.add("갈매기");
        list.add("나비");
        list.add("다람쥐");
        list.add("라마");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void solve() {

        list.stream()
                .filter(word -> word.length() >= 2)
                .forEach(System.out::println);
    }
}
