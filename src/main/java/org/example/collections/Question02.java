package org.example.collections;

import java.util.*;

public class Question02 {

    private Set<Person> set = new HashSet<>();

    public Question02() {

        set.add(new Person("김열공", 20));
        set.add(new Person("최고봉", 56));
        set.add(new Person("우등생", 16));
        set.add(new Person("나자바", 35));
    }

    public Set<Person> getSet() {
        return set;
    }

    public boolean containsPerson(String name, int age) {

        for (Person p: set) {
            System.out.println("p.toString() = " + p.toString());
        }
        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()) {
            
            Person p = iterator.next();
            System.out.println("p.toString() = " + p.toString());
        }
        
        return set.contains(new Person(name, age));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
