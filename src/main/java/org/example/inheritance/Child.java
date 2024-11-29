package org.example.inheritance;

public class Child extends Parent {

    private String name;
    private String childSchool;
    public String pub = "Child";
    public String cPub = "Child Public";

    public Child() {
        super();
    }

    public Child(String name, String childSchool) {
        super();
        this.name = name;
        this.childSchool = childSchool;
    }

    @Override
    public void printName() {
        System.out.println("Child name = " + name);
    }

    public void ChildMethod() {

        System.out.println("name = " + name);
        System.out.println("childSchool = " + childSchool);
    }
}
