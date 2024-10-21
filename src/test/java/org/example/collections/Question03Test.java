package org.example.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question03Test {

    @Test
    void getTest() {

        Question03 q03 = new Question03();

        assertEquals(q03.getScore("나자바"), 88);
        assertEquals(q03.getScore("나자바1"), null);
    }
}