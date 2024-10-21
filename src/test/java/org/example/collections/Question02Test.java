package org.example.collections;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Question02Test {

    @Test
    void getTest() {

        Question02 q02 = new Question02();

        Set<Person> set = q02.getSet();

        for (Person p : set) {

            p.toString();
        }

        assertTrue(q02.containsPerson("김열공", 20));
    }
}