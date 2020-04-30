package com.mrlove.lock;

public class MyFactory extends Factory{
    public Product createProduct(){
        return new ConcreteProductA();
    }
}