package org.example;

public class StringTest {

    void print() {

        // String에서 제공하는 메서드
        String s1 = new String("Hi!");
        String s2 = new String(" Java");

        System.out.println("s1 string length : " + s1.length());
        System.out.println(s1.charAt(1));

        s1 = s1.concat(s2);

        System.out.println(s1.concat(s2) + "!");
        System.out.println(s1.toLowerCase() + "!");
        System.out.println(s1.substring(4, 8) + "!");

        String s3 = "";
        System.out.println(s3.isEmpty());
        System.out.println(s3.isBlank());
        String s4 = "";
        System.out.println(s4.isEmpty());
        System.out.println(s4.isBlank());

        String s5 = "*-*";
        System.out.println(s5.repeat(10));

        System.out.println(s2.trim().indexOf("v"));

        System.out.println(s2.contains("java"));
        System.out.println(s2.endsWith("Java"));
        System.out.println(s2.startsWith("J"));

        // String에서 제공하는 정적 메서드
        System.out.println(String.format("%s %d", "JDK", 14));
        System.out.println(String.join("::", "A", "B", "C", "D"));
        System.out.println(String.valueOf(3.14));
    }
}
