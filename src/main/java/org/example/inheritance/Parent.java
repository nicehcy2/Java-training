package org.example.inheritance;

public class Parent {

    private String name;
    public String pub = "Parent";

    public Parent(String name) {
        this.name = name;
    }

    public Parent() {

    }

    public void printName() {
        System.out.println("name = " + name);
    }
}
