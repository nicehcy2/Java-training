package org.example;

import java.util.Arrays;

public class ArrayTest {

    public void test() {

        char a1[] = { 'J', 'a', 'v', 'a'};
        char a2[] = Arrays.copyOf(a1, a1.length);
        System.out.println(a2);

        String sa[] = {"apple", "banana", "cake", "diamond"};

        Arrays.sort(sa);
        print(sa);

        System.out.println(Arrays.binarySearch(sa, "애플"));

        Arrays.fill(sa, "기타");
        print(sa);

        Arrays.fill(sa, 2, 4, "dia");
        print(sa);
    }

    private void print(Object[] oa) {
        for (Object o : oa) {
            System.out.println(o + " ");
        }
        System.out.println();
    }
}
