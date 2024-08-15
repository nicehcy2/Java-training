package org.example;

interface IAnimal {

    void sleep();
}

interface IHuman {

    void study();
}

public class InterfaceTest implements IAnimal, IHuman {

    @Override
    public void sleep() {

    }

    @Override
    public void study() {

    }
}
