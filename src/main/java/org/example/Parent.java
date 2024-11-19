package org.example;

public class Parent {
    private String name;

    Parent() {
        System.out.println("Parent.Parent by default");
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("Parent.Parent by Name");
    }
}
