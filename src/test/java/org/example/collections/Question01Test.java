package org.example.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Question01Test {

    @Test
    void solve() {

        // when
        Question01 q01 = new Question01();

        // given
        List<String> list = q01.getList();

        // then
        Assertions.assertEquals("갈매기", list.get(0));
    }
}