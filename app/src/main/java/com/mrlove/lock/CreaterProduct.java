package com.mrlove.lock;

public class CreaterProduct {
    public static void main(String[] args) {
        Factory factory = new MyFactory();
        ConcreteProductB concreteProductA = factory.createProduct(ConcreteProductB.class);
        concreteProductA.method();
    }
}
